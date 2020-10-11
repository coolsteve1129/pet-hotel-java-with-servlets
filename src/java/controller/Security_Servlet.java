/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.DispositionType;
import business.Employee;
import business.PetType;
import business.RoleType;
import business.StateType;
import data.GetDb;
import data.DbInserts;
import data.UpdateDb;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.PasswordUtil;
import static utility.PasswordUtil.hashPassword;
import utility.ValidatorUtil;



/**
 *
 * @author hecks
 */
public class Security_Servlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response, String url) throws ServletException, IOException{
    
            getServletContext().getRequestDispatcher(url)
                .forward(request, response);
        
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String action = request.getParameter("action");
        String url = "";
        
        
        if (action.equals("manageTypes")){   
            loadCustomerPageData(request);
            url = "/admin/manageTypes.jsp";
        }
        else if (action.equals("manageEmployees")){   
            loadRoleTypePageData(request);
            url = "/admin/manageEmployees.jsp";
        }
        
        processRequest(request, response, url);
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String url = "";        
        int stateId = 0;
    
        if(action.equals("manageDispoType")){
            url = doManageType(request, response);
        }
        else if(action.equals("createEmployee")){
            url = doCreateEmployee(request, response);
        }
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    private String doCreateEmployee(HttpServletRequest request, HttpServletResponse response){
        String urlString;
        String compareMessage;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String roleTypeId = request.getParameter("employeeRole");
        int roleTypeInt = Integer.valueOf(roleTypeId);
        String userName = request.getParameter("userName");
        String newPassword = PasswordUtil.generatePassword();
        String comparePassword = newPassword;
        String hashedPassword = "";
        String saltedPassword = "";
        String compareHashedPassword = "";
        String compareSaltedPassword = "";
        String salt = PasswordUtil.getSalt();
        
        if(ValidatorUtil.isAlphabetic(firstName) && ValidatorUtil.isAlphabetic(lastName)
                && ValidatorUtil.hasText(userName)){   
        saltedPassword = salt.concat(newPassword);
        try{
            hashedPassword = PasswordUtil.hashPassword(saltedPassword);
        }
        catch(NoSuchAlgorithmException e){
            System.out.println();
        }   
       
        Employee employee = new Employee();
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setRoleTypeId(roleTypeInt);
        employee.setHashPassword(hashedPassword);
        employee.setSaltPassword(saltedPassword);
                    
        DbInserts.insertEmployee(employee);
        
       String employeeSalt = employee.getSaltPassword();
        try{
            compareHashedPassword = PasswordUtil.hashPassword(employeeSalt);
        }
        catch(NoSuchAlgorithmException e) {
            System.out.println();
        }
        if(hashedPassword.equals(compareHashedPassword)){
           compareMessage = "Password Matches!!!";
       }
       else{
           compareMessage = "Password doesn't match";
       }
        
        request.setAttribute("hashedPassword", hashedPassword);
        request.setAttribute("compareMessage", compareMessage);
        request.setAttribute("employee", employee);
        urlString = "/admin/manageEmployees.jsp";
        }
        else{
            String message = "Please enter valid names";
            request.setAttribute("message", message);
            urlString = "/admin/manageEmployees.jsp";
        }
        return urlString;
    }
    private String doManageType(HttpServletRequest request, HttpServletResponse response){
        String urlString;
        DispositionType dispoType = new DispositionType();
        PetType petType = new PetType();
        StateType stateType = new StateType();
        
        String manageTypeRadio = request.getParameter("manageType");
        
        String editId = request.getParameter("editId");
        String editShortDesc = request.getParameter("editShortDesc");
        String editLongDesc = request.getParameter("editLongDesc");
        String editIsActive = request.getParameter("editIsActive");
        
        String insertShortDesc = request.getParameter("insertShortDesc");
        String insertLongDesc = request.getParameter("insertLongDesc");
        String insertIsActive = request.getParameter("insertIsActive");
        if(editId != null){
            if(manageTypeRadio.equals("dispoType")){
                
               int editIdInt = Integer.valueOf(editId);
               int editIsActiveInt = Integer.valueOf(editIsActive);
               dispoType.setDispoId(editIdInt);
               dispoType.setShortDesc(editShortDesc);
               dispoType.setLongDesc(editLongDesc);
               dispoType.setIsActive(editIsActiveInt);
               
               UpdateDb.updateDispoType(dispoType);  
               request.getServletContext().setAttribute("dispoList", GetDb.getAllDispositions());
            }
        
            else if(manageTypeRadio.equals("petType")){
             
               int editIdInt = Integer.valueOf(editId);
               int editIsActiveInt = Integer.valueOf(editIsActive);
               petType.setPetTypeId(editIdInt);
               petType.setShortDesc(editShortDesc);
               petType.setLongDesc(editLongDesc);
               petType.setIsActive(editIsActiveInt);
               
               UpdateDb.updatePetType(petType);      
               
               request.getServletContext().setAttribute("petTypeList", GetDb.getAllPetTypes());
            }
            else if(manageTypeRadio.equals("stateType")){   
            
               int editIdInt = Integer.valueOf(editId);
               int editIsActiveInt = Integer.valueOf(editIsActive);
               stateType.setStateId(editIdInt);
               stateType.setShortDesc(editShortDesc);
               stateType.setLongDesc(editLongDesc);
               stateType.setIsActive(editIsActiveInt);
               
               UpdateDb.updateStateType(stateType);
               request.getServletContext().setAttribute("stateList", GetDb.getAllStates());
            }
        }
            if(manageTypeRadio.equals("insertDispo")){
                int insertIsActiveInt = Integer.valueOf(insertIsActive);
                dispoType.setShortDesc(insertShortDesc);
                dispoType.setLongDesc(insertLongDesc);
                dispoType.setIsActive(insertIsActiveInt);
                
                DbInserts.insertDispo(dispoType);
                manageTypeRadio = "dispoType";
               request.getServletContext().setAttribute("dispoList", GetDb.getAllDispositions());
            }
            else if(manageTypeRadio.equals("insertPetType")){
                int insertIsActiveInt = Integer.valueOf(insertIsActive);
                petType.setShortDesc(insertShortDesc);
                petType.setLongDesc(insertLongDesc);
                petType.setIsActive(insertIsActiveInt);
                
                DbInserts.insertPetType(petType);
                manageTypeRadio = "petType";
               request.getServletContext().setAttribute("petTypeList", GetDb.getAllPetTypes());
            }
            else if(manageTypeRadio.equals("insertState")){
                int insertIsActiveInt = Integer.valueOf(insertIsActive);
                stateType.setShortDesc(insertShortDesc);
                stateType.setLongDesc(insertLongDesc);
                stateType.setIsActive(insertIsActiveInt);
                
                DbInserts.insertStateType(stateType);
                manageTypeRadio = "stateType";                
               request.getServletContext().setAttribute("stateList", GetDb.getAllStates());
            }
              

            ServletContext sc = getServletContext();
            List<DispositionType> dispoList = (List<DispositionType>) sc.getAttribute("dispoList");
            List<StateType> stateTypeList = (List<StateType>) sc.getAttribute("stateList");
            List<PetType> petTypeList = (List<PetType>) sc.getAttribute("petTypeList");
            request.setAttribute("dispoList", dispoList);
            request.setAttribute("petTypeList", petTypeList);
            request.setAttribute("stateList", stateTypeList); 
       request.setAttribute("manageTypeRadio", manageTypeRadio);
        urlString = "/admin/manageTypes.jsp";
        
        
        return urlString;
            
        
    }
    
    private void loadRoleTypePageData(HttpServletRequest request) {
        
        
        List<RoleType> employeeRoleList = GetDb.getAllRoleTypes();
        
        
        HttpSession session = request.getSession();
            
        session.setAttribute("employeeRoleList", employeeRoleList);
       
                
    }
    private void loadCustomerPageData(HttpServletRequest request) {
        
        
        List<StateType> stateList = GetDb.getAllStates();
        
        HttpSession session = request.getSession();
            
        session.setAttribute("stateList", stateList);
       
                
    }
}