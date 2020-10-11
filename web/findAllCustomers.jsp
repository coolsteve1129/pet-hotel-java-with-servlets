<%-- 
    Document   : findCustomer
    Created on : Dec 3, 2019, 4:31:17 AM
    Author     : hecks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
    
<table border="2">
    
    <tr>
            <th>Customer ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Postal Code</th>
            <th>Comments</th>
            <th>Status</th>
            <th>Manage</th>        
    </tr>
    <c:forEach var="customers" items="${customerList}">
    <tr>        
        <td name="customerId">${customers.customerId}</td>
        <td>${customers.firstName} ${customer.lastName}</td>
        <td>${customers.email}</td>
        <td>${customers.address}</td>
        <td>${customers.city}</td>
        <td>${customers.state}</td>
        <td>${customers.zipCode}</td>
        <td>${customers.comments}</td>
        <td>${customers.isActiveString}</td>
        <td>
        <form action="witc" method="post">
            <input type="hidden" name="action" value="editCustomer">
            <input type="hidden" name="customerId" value="${customers.customerId}"/>
                <input type="submit" value="Edit" class="editbuttons"/>
        
            </form>    
        </td>
    </tr>
    </c:forEach>
</table>
<c:import url="/includes/footer.jsp"/>