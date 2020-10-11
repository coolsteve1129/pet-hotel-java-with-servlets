<%-- 
    Document   : chooseManageType
    Created on : Feb 24, 2020, 3:39:18 AM
    Author     : hecks
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
<div>
    <a href="<c:url value = "admin?action=manageTypes"/>">
   <input type="button" value="Manage Disposition Types"/>
    </a><br>
    <a href="<c:url value = "admin?action=manageEmployees"/>">
   <input type="button" value="Manage Employees" />
</a>
</div>
<c:import url="/includes/footer.jsp" /> 
