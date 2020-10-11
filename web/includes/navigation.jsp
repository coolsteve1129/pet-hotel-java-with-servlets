<%-- 
    Document   : navigation
    Created on : Mar 1, 2020, 6:53:54 PM
    Author     : hecks
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
    <a href= "<c:url value = "witc?action=home"/>">Home</a><br>
    <a href="<c:url value = "witc?action=search"/>">Customer</a><br>
    <a href="<c:url value = "auth_login?action=manage"/>">Admin</a><br>
    <a href="<c:url value = "witc?action=getAllPets"/>">Pet List</a><br>
</nav>
