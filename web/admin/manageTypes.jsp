<%-- 
    Document   : manageDispoTypes
    Created on : Feb 24, 2020, 4:11:13 AM
    Author     : hecks
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="manageDispoType">
                
                <label class="radioButtonLabels"><input type="radio" name="manageType" value="dispoType"  checked/>Disposition Types</label>
                <label class="radioButtonLabels"><input type="radio" name="manageType" value="petType" />Pet Types</label>
                <label class="radioButtonLabels"><input type="radio" name="manageType" value="stateType"/>State Types</label><br>
                                                
                <input type="submit" value="Submit" class="non-table"/><br>
            </form>
    </div>
    <c:choose>
        <c:when test="${manageTypeRadio == null}">
            
        </c:when>
        
        <c:when test="${manageTypeRadio == 'stateType'}">

            <table class="tableManageType" border="2">
                <tr>
                    <th>ID</th>
                    <th>Short Desc</th>
                    <th>Long Desc</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="state" items="${stateList}">
                    
                    <form action="admin" method="post">
                <tr>
                    
                    <td>${state.stateId}</td>
                    <td><input class="tableTextbox" type="text" name="editShortDesc" value="${state.shortDesc}"/></td>
                    <td><input class="tableTextbox" type="text" name="editLongDesc" value="${state.longDesc}"/></td>
                    <td>
                    <select name="editIsActive" id="state">
                    <option value="0" 
                            <c:if test="${state.isActive eq 0}">selected="selected" </c:if>
                            >                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" 
                            <c:if test="${state.isActive eq 1}">selected="selected" </c:if>
                            >
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    <td>
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="hidden" name="editId" value="${state.stateId}"/>
                        <input type="hidden" name="manageType" value="stateType">
                            <input type="submit" value="Edit" class="editbuttons"/>
                        
                    </td>
                </tr>   
                </form>
                </c:forEach>
                <tr>
                    
                        <form action="admin" method="post">
                    <td></td>
                    <td><input class="tableTextbox" type="text" name="insertShortDesc"/></td>
                    <td><input class="tableTextbox" type="text" name="insertLongDesc"/></td>
                    <td>
                        <select class="tableTextbox" name="insertIsActive" id="state">
                    <option value="0">                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" selected>
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    <td>
                        
                        <input type="hidden" name="manageType" value="insertState">
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="submit" value="Add" class="editbuttons">
                        </form>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:when test="${manageTypeRadio == 'petType'}">

            <table class="tableManageType" border="2">
                <tr>
                    <th>ID</th>
                    <th>Short Desc</th>
                    <th>Long Desc</th>
                    <th>Active</th>

                </tr>
                <c:forEach var="petType" items="${petTypeList}">
                
                    <form action="admin" method="post">
                <tr>
                    <td>${petType.petTypeId}</td>
                    <td><input class="tableTextbox" type="text" name="editShortDesc" value="${petType.shortDesc}"/></td>
                    <td><input class="tableTextbox" type="text" name="editLongDesc" value="${petType.longDesc}"/></td>
                    <td>
                        <select  name="editIsActive" id="petType">
                    <option value="0" 
                            <c:if test="${petType.isActive eq 0}">selected="selected" </c:if>
                            >                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" 
                            <c:if test="${petType.isActive eq 1}">selected="selected" </c:if>
                            >
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    
                    <td>
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="hidden" name="editId" value="${petType.petTypeId}"/>
                        <input type="hidden" name="manageType" value="petType">
                            <input type="submit" value="Edit" class="editbuttons"/>
                            
                    </td>
                </tr>
                    </form>
                </c:forEach>
                <tr>
                    
                        <form action="admin" method="post">
                    <td></td>
                    <td><input class="tableTextbox" type="text" name="insertShortDesc"/></td>
                    <td><input class="tableTextbox" type="text" name="insertLongDesc"/></td>
                    <td>
                        <select name="insertIsActive" id="state">
                    <option value="0">                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" selected>
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    <td>
                        
                        <input type="hidden" name="manageType" value="insertPetType">
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="submit" value="Add" class="editbuttons">
                        </form>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:when test="${manageTypeRadio == 'dispoType'}">

            <table class="tableManageType" border="2">
                <tr>
                    <th>ID</th>
                    <th>Short Desc</th>
                    <th>Long Desc</th>
                    <th>Active</th>

                </tr>
                <c:forEach var="dispoType" items="${dispoList}">
                
                    <form action="admin" method="post">
                <tr>
                    <td>${dispoType.dispoId}</td>
                    <td><input class="tableTextbox" type="text" name="editShortDesc" value="${dispoType.shortDesc}"/></td>
                    <td><input class="tableTextbox" type="text" name="editLongDesc" value="${dispoType.longDesc}"/></td>
                    <td>
                        <select name="editIsActive" id="dispoType">
                    <option value="0" 
                            <c:if test="${dispoType.isActive eq 0}">selected="selected" </c:if>
                            >                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" 
                            <c:if test="${dispoType.isActive eq 1}">selected="selected" </c:if>
                            >
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    
                    <td>
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="hidden" name="editId" value="${dispoType.dispoId}"/>
                        <input type="hidden" name="manageType" value="dispoType">
                            <input type="submit" value="Edit" class="editbuttons"/>
                            
                    </td>
                </tr>
                    </form>
                </c:forEach>
                <tr>
                    
                        <form action="admin" method="post">
                    <td></td>
                    <td><input class="tableTextbox" type="text" name="insertShortDesc"/></td>
                    <td><input class="tableTextbox" type="text" name="insertLongDesc"/></td>
                    <td>
                        <select name="insertIsActive" id="state">
                    <option value="0">                                  
                        <c:out value="Deleted"/></option>  
                    <option value="1" selected>
                        <c:out value="Active"/></option>                                  
                    </select>
                    </td>
                    <td>
                        
                        <input type="hidden" name="manageType" value="insertDispo">
                        <input type="hidden" name="action" value="manageDispoType">
                        <input type="submit" value="Add" class="editbuttons">
                        </form>
                    </td>
                </tr>
            </table>
        </c:when>
    </c:choose>
<c:import url="/includes/footer.jsp"/>
