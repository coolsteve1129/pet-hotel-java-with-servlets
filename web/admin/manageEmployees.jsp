<%-- 
    Document   : manageEmployees
    Created on : Mar 2, 2020, 1:34:00 AM
    Author     : hecks
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
<div>
    <p>${message}</p>
<form class="form" action="admin" method="post">    
    <input type="hidden" name="action" value="createEmployee">
    <label>First Name:</label>
    <input type="text" name="firstName"/><br>
    <label>Last Name:</label>
    <input type="text" name="lastName"/><br>
    <label>User Name:</label>
    <input type="text" name="userName"/><br>
    <label>Employee Role:</label>
                <select name="employeeRole" id="employee_role">            
                <c:forEach  var="employeeRoleList" items="${employeeRoleList}">
                     <option value="${employeeRoleList.roleTypeId}" ${employeeRoleList.roleTypeId == roleTypeId ? "selected='selected'" : ""}>
                        <c:out value="${employeeRoleList.longDesc}"/></option>
                    </option>
                </c:forEach>
                </select><br>
                <input type="submit" value="Submit"/>
</form>
</div>
<div class="displayEmployeeGroup">
                <label>Name: </label>
                <label>${employee.firstName} ${employee.lastName}</label><br>
                <label>Role Type: </label>
                <label>${employee.getRoleTypeString()}</label><br>
                <label>Hash Password: </label>
                <label>${employee.hashPassword}</label>    
</div>
<c:import url="/includes/footer.jsp" /> 