<%-- 
    Document   : search
    Created on : Dec 3, 2019, 2:36:07 AM
    Author     : hecks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />

            <p><i><c:out value="${message}" default="Hello"/></i></p>
            <h2>Customer Search</h2>
<div>
            <form action="witc" method="post">
                <input type="hidden" name="action" value="findCustomer">
                
                <label class="radioButtonLabels"><input type="radio" name="searchType" value="phone" id="phoneRadio"  checked/>Phone</label>
                <label class="radioButtonLabels"><input type="radio" name="searchType" value="lastName" />Last Name</label>
                <label class="radioButtonLabels"><input type="radio" name="searchType" value="getAllCustomers" id="getAllCustomers" />Get All Customers</label><br>
                
                
                <input type="text" name="customerSearch" id="customerSearchText"><br>
                
                <input type="submit" value="Submit" class="non-table"/><br>
            </form>
               
</div>  
    
<c:import url="/includes/footer.jsp" />