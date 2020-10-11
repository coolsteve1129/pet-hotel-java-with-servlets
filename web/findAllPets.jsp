<%-- 
    Document   : findCustomer
    Created on : Dec 3, 2019, 4:31:17 AM
    Author     : hecks
--%>

  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.jsp" />
    
<table border="2">
    <tr>
        <th>Pet ID</th>
        <th>Pet Name</th>
        <th>Pet Gender</th>
        <th>Pet's Birthday</th>
        <th>Pet Disposition</th>
        <th>Pet Type</th>
        <th>Last Kennel Cough</th>
        <th>Breed</th>
        <th>Comments</th>
        <th>Status</th>
        <th>Manage</th>
    </tr>
    <c:forEach var="pet" items="${petList}">
    <tr>
        <td>${pet.petId}</td>
        <td>${pet.petName}</td>
        <td>${pet.formattedGender}</td>
        <td>${pet.petDOB}</td>
        <td>${pet.petDispositionString}</td>
        <td>${pet.petTypeString}</td>
        <td>${pet.unformattedDate}</td>
        <td>${pet.breed}</td>
        <td>${pet.comments}</td>
        <td>${pet.isActiveString}</td>
        <td>
        <form action="witc" method="post">
            <input type="hidden" name="action" value="editFoundPet">
            <input type="hidden" name="petId" value="${pet.petId}"/>
                <input type="submit" value="Edit" class="editbuttons"/>
        
            </form>    
        </td>
    </tr>
    </c:forEach>
</table>
<c:import url="/includes/footer.jsp"/>