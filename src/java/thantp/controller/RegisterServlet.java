/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thantp.controller;

import ThangTP.reg.RegDAO;
import ThangTP.reg.RegDTO;
import ThangTP.reg.RegError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phuth
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private final String LOGIN_PAGE = "login.html";
    private final String INVAILD_PAGE = "register.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INVAILD_PAGE;
        try{
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String phoneRegex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        String username = request.getParameter("registUserName");
        String password = request.getParameter("passWord");
        String confirmpass = request.getParameter("repassWord");
        String fullname = request.getParameter("registName");
        String email = request.getParameter("registEmail");
        Pattern emailpattern = Pattern.compile(emailRegex);
        Pattern phonepattern = Pattern.compile(phoneRegex);
        String phoneNumber = request.getParameter("registPhone");
        boolean check = true;
        RegError userError = new RegError();
            //check user error
            if (username.trim().length() < 6 || username.trim().length() > 30) {
                check = false;
                userError.setIdErr("Username length must be from 6 -30");
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                check = false;
                userError.setPasswordErr("Password length must be from 6 - 20");
            } else if (!password.trim().equals(confirmpass.trim())) {
                check = false;
                userError.setConfirmpasswordtErr("Confirm password is not match");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                check = false;
                userError.setFullNameErr("Fullname length must be from 2 - 50");
            }
            if(!emailpattern.matcher(email).matches()){
                check = false;
                userError.setEmailErr("Invalid Email");
            }
            if(!phonepattern.matcher(phoneNumber).matches()){
                check = false;
                userError.setPhoneNumberErr("Invalid phone number");
            }
            if(check){
                RegDAO dao = new RegDAO();
                RegDTO user = new RegDTO(username, password, fullname, "", email, phoneNumber, 1, false);
                boolean CheckDup = dao.CheckDuplicate(username);
                if(CheckDup){
                    userError.setIdErr("Account already existed");
                    request.setAttribute("USER_ERROR", userError);
                }else{
                    boolean checkRegister = dao.RegisterAccount(user);
                    if(checkRegister){
                        url = LOGIN_PAGE;
                    }else{
                        userError.setErrorMess("Cannot register this account");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }
            }else{
                 request.setAttribute("USER_ERROR", userError);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
