<%-- 
    Document   : login_error
    Created on : Mar 1, 2020, 6:05:17 PM
    Author     : hecks
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
        <h1>Admin Login Form - Error</h1>
        <p>You did not log in successfully.</p>
        <p>Please check your username and password and try again.</p>
        <p>If that doesn't work, you may need to implement the JDBC realm 
            as described in chapter 16.</p>
        <form action="auth_login" method="post">
    <input type="hidden" name="action" value="login">
            <label class="pad_top">Username</label>
            <input type="text" name="user_name"><br>
            <label class="pad_top">Password</label>
            <input class="password" type="password" name="password"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="margin_left">    
        </form>
    <c:import url="/includes/footer.jsp" />

