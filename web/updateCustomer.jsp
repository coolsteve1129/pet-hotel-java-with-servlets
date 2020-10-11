<%-- 
    Document   : customer
    Created on : Oct 9, 2019, 2:54:55 AM
    Author     : Steve Heck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />

            <p><i><c:out value="${message}" default="Hello"/></i></p>
            <h2>Customer Info</h2>
            
            
            <form class="form" action="witc" method="post">
                <input type="hidden" name="action" value="updateCustomer">
                
                <input type="hidden" name="customerId" value="${customer.customerId}" <c:out value="${customer.customerId}"/>>
                <label>First name: </label>
                <input type="text" name="firstName" value="${customer.firstName}" <c:out value="${customer.firstName}"/>><br>
                
                <label>Last name: </label>
                <input type="text" name="lastName" value="${customer.lastName}" <c:out value="${customer.lastName}"/>><br>
                
                <label>Address: </label>
                <input type="text" name="address" value="${customer.address}" <c:out value="${customer.address}"/>><br>
                
                <label>City: </label>
                <input type="text" name="city" value="${customer.city}" <c:out value="${customer.city}"/>><br>
                
                <label>State: </label>
                <select name="state" id="state">
                
                <c:forEach  var="stateList" items="${stateList}">
                     <option value="${stateList.stateId}" ${stateList.stateId == customer.stateId ? 'selected="selected"' : ''}>
                        <c:out value="${stateList.longDesc}"/></option>
                    </option>
                </c:forEach>
                </select><br>
                
                <label>Zip Code: </label>
                <input type="text" name="zipCode" value ="${customer.zipCode}" <c:out value="${customer.zipCode}"/>><br>
                
                <label>Phone: </label>
                <input type="text" name="phone" value="${customer.phone}"<c:out value="${customer.phone}"/>><br>
                
                <label>Email: </label>
                <input type="text" name="email" value="${customer.email}" <c:out value="${customer.email}"/>><br>
                
                <label>Comments: </label>
                <textArea name="comments"<c:out value="${customer.comments}"/>>${customer.comments}</textarea><br>
                
                <label>&nbsp;</label>
                <input type="submit" value="Submit"class="non-table"/><br>
            </form>
<c:import url="/includes/footer.jsp"/>

