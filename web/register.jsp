<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>

    </head>
    <body>
        <div id="login">
            <div id="login_form">
                <form action="MainServlet" method="POST">
                    <h2>Register</h2>
                    
                    <p>FullName</p>
                    <input type="text" name="registName" id="login_name regist_name" required="">
                     <p style="color:red">
                    ${requestScope.USER_ERROR.getFullNameErr()}
                    </font><br/>
                    
                    <p>UserName</p>
                    <input type="text" name="registUserName" id="login_Username regist_Username" required="">
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getIdErr()}
                    </p>
                    
                    <p>PhoneNumber</p>
                    <input type="text" name="registPhone" id="login_Phone regist_Phone" required="">
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getPhoneNumberErr()}
                    </p>
                    
                    <p>Email</p>
                    <input type="text" name="registEmail" id="login_Email regist_Email">
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getEmailErr()}
                    </p>
                    
                    <p>Password</p>
                    <input type="password" name="passWord" id="pass regist_pass" required="">
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getPasswordErr()}
                    </p>
                    
                    <p>Confirm Password</p>
                    <input type="password" name="repassWord" id="pass re_regist_pass" ><br/>
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getConfirmpasswordtErr()}
                    </p>
                    
                    <p style="color:red">
                    ${requestScope.USER_ERROR.getErrorMess()}
                    </p>
                    <!-- <button type="submit" name="loginBtn" class="login_btn">ĐĂNG NHẬP</button> -->
                    <input type="submit" name="BTACTION" value="Register"/>
                    <input type="reset" value="Reset"/>
                    
                </form>
                <hr class="regist_hr">
                <div class="to_regist to_login">
                    <p>Already Have Account?</p>
                    <a href="login.html">Login</a>
                </div>
            </div>
        </div>
    </body>

</html>
