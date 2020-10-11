<%-- 
    Document   : pet
    Created on : Oct 12, 2019, 4:59:16 AM
    Author     : Steve Heck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />

        <h2>Pet Info</h2>
        
        <fieldset>
            <legend>Customer ID: value="${customer.customerId}"</legend>
                <label>Name: </label>
                <label>${customer.firstName} ${customer.lastName}</label><br>
                <label>Email: </label>
                <label>${customer.email}</label><br>
                <label>Phone: </label>
                <label>${customer.formattedPhoneString}</label><br>    
            </fieldset>
        <fieldset> 
            <legend>Pet</legend>
            
            <p><i><c:out value="${message}" default="Hello"/></i></p>
            <form class="form" action="witc" method="post"> 
            <input type="hidden" name="action" value="createPet">
            
            <label>Pet Name: </label>
            <input type="text" name="petName" value=""<c:out value="${pet.petName}"/>><br>
            
            <label>Pet Type: </label>
            <select name="petType" id="petType">
                <c:forEach items="${petTypeList}" var="petTypeList">
                    <option value="${petTypeList.petTypeId}">
                        <c:out value="${petTypeList.longDesc}"></c:out>
                    </option>
                </c:forEach>
            </select><br>
            
            <label>Gender: </label>            
            <select name="petGender" id="petGender">
                <c:forEach items="${genderList}" var="option">
                    <option value="${option}">
                        <c:out value="${option.gender}"></c:out>
                    </option>
                </c:forEach>
            </select><br>
            
            <label>Pet DOB: </label>
            <input type="text" name="petDOB" value=""<c:out value="${pet.petDOB}"/>><br>
            
            <label>Disposition: </label>
            <select name="petDisposition" id="petDisposition">            
                <c:forEach items="${dispoList}" var="dispoList">
                     <option value="${dispoList.dispoId}" ${dispoList.dispoId == dispoId ? "selected='selected'" : ""}>
                        <c:out value="${dispoList.longDesc}"/></option>
                    </option>
                </c:forEach>
            </select><br>
            
            <label>Kennel Cough Date: </label>
            <input type ="text" name="kennelCoughDate" value=""<c:out value="${pet.kennelCoughDate}"/>><br>
            
            <label>Breed: </label>
            <input type="text" name="breed" value=""<c:out value="${pet.breed}"/>><br>
            
            
            <label>Comments: </label>
                <textArea name="comments" value=""></textarea><br>
                
            <input type="hidden" name="customerId" value="${pet.customerId}">
            <a href="witc?action=newPet">Add a human customer</a><br>
            <label>&nbsp;</label>
                <input type="submit" value="Submit" class="non-table"/><br>
                
            </form>
        </fieldset>
<c:import url="/includes/footer.jsp"/>
