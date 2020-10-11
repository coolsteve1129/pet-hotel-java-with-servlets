<%-- 
    Document   : index
    Created on : Oct 9, 2019, 2:52:45 AM
    Author     : Steve Heck
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
<div>
    <a href="<c:url value = "witc?action=search"/>">Add a human customer</a><br>
    <a href="<c:url value = "auth_login?action=manage"/>">Admin</a>
</div>
<c:import url="/includes/footer.jsp" /> 