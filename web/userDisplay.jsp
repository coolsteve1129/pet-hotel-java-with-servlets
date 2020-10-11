<%-- 
    Document   : pet
    Created on : Oct 12, 2019, 4:59:16 AM
    Author     : Steve Heck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />


            <p><i>${message}</i></p>
        <h2>Pet Info</h2>
        
        <fieldset>
            <legend>Customer ID: ${customer.customerId}</legend>
                <label>Name: </label>
                <label>${customer.firstName} ${customer.lastName}</label><br>
                <label>Email: </label>
                <label>${customer.email}</label><br>
                <label>Phone: </label>
                <label>${customer.formattedPhoneString}</label>    
            </fieldset>
        <fieldset> 
            <legend>Pet</legend>
            <label>Pet Name: </label>
            <label>${pet.petName}</label><br>
            <label>Pet Gender: </label>
            <label>${pet.petGender}</label><br>
            <label>Pet Date of Birth: </label>
            <label>${pet.petDOB}</label><br>
            <label>Disposition: </label>
            <label>${pet.petDispositionString}</label>
        </fieldset>
        
        <input type="hidden" name="customerId" value="${customer.customerId}">
        <a href="<c:url value = "witc?action=search"/>">Search For Customer</a><br>
        <a href="<c:url value = "witc?action=createCustomer"/>">Enter New Customer</a><br>
        <a href="<c:url value = "witc?action=createPet"/>">Enter New Pet For This Customer</a><br>
        <br>
            
            <p>The current date is ${requestScope.currentDate}</p>
<c:import url="/includes/footer.jsp" />
