<%-- 
    Document   : displayEmployee
    Created on : Mar 28, 2020, 12:03:13 AM
    Author     : hecks
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
<div>           
    <p>${compareMessage}</p>
                <label>Name: </label>
                <label>${employee.firstName} ${employee.lastName}</label><br>
                <label>Role Type: </label>
                <label>${employee.getRoleTypeString()}</label><br>
                <label>Hash Password: </label>
                <label>${employee.hashPassword}</label>    
</div>
<c:import url="/includes/footer.jsp" />
