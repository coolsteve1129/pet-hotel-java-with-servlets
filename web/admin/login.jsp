<%-- 
    Document   : login
    Created on : Feb 29, 2020, 7:01:03 PM
    Author     : hecks
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
<div>
<form action="auth_login" method="post">
    <input type="hidden" name="action" value="login">
    <label>Username</label>
    <input type="text" name="user_name"/><br>
    <label>Password</label>
    <input class="password" type="password" name="password"/><br>
    <input type="submit" value="login"/>
</form>
</div>
<c:import url="/includes/footer.jsp" /> 
