<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
                <h2>Login Page</h2>
                <p>Username</p>
                <input type="text" name="USERNAME" id="login_name">
                <p>Password</p>
                <input type="password" name="PASSWORD" id="pass">
                <!-- <button type="submit" name="loginBtn" class="login_btn">??NG NH?P</button> -->
                 <p style="color:red">
                ${requestScope.USER_ERROR.getErrorMess()}
                </p>
                <input type="submit" name="BTACTION" value="Login"/>
                
            </form>
            <hr class="login_hr">
            <div class="to_regist">
                <p>Don't have account?</p>
                <a href="register.jsp">Register here</a>
            </div>
        </div>
    </div>
</body>

</html>