<%-- 
    Document   : findCustomer
    Created on : Dec 3, 2019, 4:31:17 AM
    Author     : hecks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
    
<table border="2">
    <tr><th>Customer ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Postal Code</th>
        <th>Comments</th>
        <th>Active</th>
        <th>Manage</th>
    </tr>
    <tr>
        <td name="customerId">${customer.customerId}</td>
        <td>${customer.firstName} ${customer.lastName}</td>
        <td>${customer.email}</td>
        <td>${customer.address}</td>
        <td>${customer.city}</td>
        <td>${customer.state}</td>
        <td>${customer.zipCode}</td>
        <td>${customer.comments}</td>
        <td>${customer.isActiveString}</td>
        
        <td>
        <form action="witc" method="post">
            <input type="hidden" name="action" value="editCustomer">
            <input type="hidden" name="customerId" value="${customer.customerId}"/>
                <input type="submit" value="Edit"/>
        
            </form>    
        </td>
    </tr>
</table>
<c:import url="/includes/footer.jsp"/>