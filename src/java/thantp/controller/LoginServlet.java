/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thantp.controller;

import ThangTP.Utils.DBHelpers;
import ThangTP.reg.RegDAO;
import ThangTP.reg.RegDTO;
import ThangTP.reg.RegError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    private final String SEARCH_PAGE = "user.jsp";
    private final String OWNER_PAGE = "owner.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String INVAILD_PAGE = "login.jsp";

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

        try {
            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");
            String phonenumber = request.getParameter("USERNAME");
            RegError userError = new RegError();
            //Call DAO method -> new DAO obj then call DAO obj
            RegDAO dao = new RegDAO();
            RegDTO dto = dao.chkLogin(username, phonenumber, password);
            HttpSession session = request.getSession();
            if (dto != null) {
                session.setAttribute("LOGIN_USER", dto);
                int role = dto.isRole();
                if (role == 1) {
                    url = SEARCH_PAGE;
                } else if (role == 2) {
                    url = OWNER_PAGE;
                } else if (role == 3) {
                    url = ADMIN_PAGE;
                }
            } else {
                userError.setErrorMess("Username or password is wrong !!!");
                    request.setAttribute("USER_ERROR", userError);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            //do hiện đuôi ở tk " đầu bếp "
            // response.sendRedirect(url);
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
