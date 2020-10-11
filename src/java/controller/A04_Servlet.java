/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Customer;
import enums.GenderEnum;
import business.Pet;
import data.GetDb;
import business.DispositionType;
import business.StateType;
import business.PetType;
import data.DbInserts;
import data.UpdateDb;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.ValidatorUtil;
import utility.StevesDate;

/**
 *
 * @author Steve Heck
 */
public class A04_Servlet extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String url = "";
        if(action.equals("home")){
            url="/index.jsp";
            loadCustomerPageData(request);
        }
        else if(action.equals("search")){
        HttpSession session = request.getSession();
        session.invalidate();
            loadCustomerPageData(request);
            url = "/search.jsp";
        }
        else if (action.equals("createCustomer")){   
            String phone = "";
            String lastName = "";
        HttpSession session = request.getSession();
        session.invalidate();
            request.setAttribute("phone", phone);
            request.setAttribute("lastName", lastName);
            loadCustomerPageData(request);
            url = "/newCustomer.jsp";
        }
        else if(action.equals("getAllPets")){
            List<Pet> allPets = GetDb.getAllPets();
            request.setAttribute("petList", allPets);
     
            url= "/findAllPets.jsp";
        }
        
        
        else if (action.equals("createPet")){
            
        List<DispositionType> dispoList = GetDb.getAllDispositions();
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        List<PetType> petTypeList = GetDb.getAllPetTypes();
            Pet pet = new Pet();
            request.getAttribute("customerId");
            request.setAttribute("dispoList", dispoList);
            request.setAttribute("genderList", genderList);
            request.setAttribute("petTypeList", petTypeList);
            url = "/newPet.jsp";
        }
        else{
            loadPetPageData(request);
            url = "/a;lskdjf;lkj";
        }
        
    
        processRequest(request, response, url);
         }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOExuption if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String url = "";        
        int stateId = 0;
        if(action.equals("findCustomer")){
            
            url = doFindCustomer(request, response);
        }
        else if(action.equals("createCustomer")){     
            String phone = request.getParameter("phone");
            
            request.setAttribute("stateId", stateId);
            url = doNewCustomer(request, response);        
        }
        else if(action.equals("updateCustomer")){                  
            request.setAttribute("stateId", stateId);
            url = doUpdateCustomer(request, response);        
        }
        else if(action.equals("editCustomer")){
            
            url = doEditCustomer(request, response);
        }
        else if(action.equals("editPet")){
            
            url = doEditPet(request, response);
        }
        
        else if(action.equals("editFoundPet")){
            
            url = doEditFoundPet(request, response);
        }
        else if(action.equals("updatePet")){
            
            url = doUpdatePet(request, response);
        }
        else if(action.equals("createPet")){
          
            url = doNewPet(request, response);
             
        }
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    private String doUpdateCustomer(HttpServletRequest request, HttpServletResponse response){
        String urlString;
                HttpSession session = request.getSession();
 
        List<DispositionType> dispoList = GetDb.getAllDispositions();
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        List<PetType> petTypeList = GetDb.getAllPetTypes();
        
        
        Pet pet = new Pet();
        Customer customer = new Customer();
        Random r = new Random();
        int random = r.nextInt();
       
        String message = "";
        
        int lastId = 0;
        
        String id = request.getParameter("customerId");
        lastId = Integer.valueOf(id);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state= request.getParameter("state");
        int stateId = Integer.valueOf(state);
        String zipCode = request.getParameter("zipCode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String comments = request.getParameter("comments");
        
        List<Pet> petList = GetDb.getPetsByCustomerId(lastId);
        if(!petList.isEmpty()){
        if(ValidatorUtil.isAlphabetic(firstName) && ValidatorUtil.isAlphabetic(lastName)
                && ValidatorUtil.hasText(address) && ValidatorUtil.isValidZipCode(zipCode)
                ){
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("phone", phone);
            session.setAttribute("email", email);
            session.setAttribute("customerId", lastId);
            session.setMaxInactiveInterval(-1);
           
            customer.setCustomerId(lastId);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setState(state);
            customer.setStateId(stateId);
            customer.setZipCode(zipCode);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setComments(comments);
            
            
            pet = GetDb.getPetByCustomerId(lastId);
            
            UpdateDb.updateCustomer(customer);
            request.setAttribute("customerId", lastId);
            request.setAttribute("petTypeList", petTypeList);
            request.setAttribute("genderList", genderList);
            request.setAttribute("dispoList", dispoList);
            
            session.setAttribute("petTypeList", petTypeList);
            session.setAttribute("genderList", genderList);
            session.setAttribute("dispoList", dispoList);
            request.setAttribute("petList", petList);
            
            session.setAttribute("customer", customer);
            
            session.setAttribute("pet", pet);
            request.setAttribute("pet", pet);
            request.setAttribute("customer", customer);
            session.setAttribute("customer", customer);
            urlString = "/findAllPets.jsp";
            
        }
        else{
            message = "please enter all required fields";
            urlString = "/newCustomer.jsp";
        }
            if(phone.length() < 10 || phone.length() > 10){
                message = "please enter a 10 digit phone number";
                urlString = "/newCustomer.jsp";
            }
        request.setAttribute("message", message);
        }
        else{
            request.setAttribute("phone", phone);
            request.setAttribute("lastName", lastName);            
        
            
            customer.setCustomerId(lastId);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setState(state);
            customer.setStateId(stateId);
            customer.setZipCode(zipCode);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setComments(comments);
            
            List<StateType> stateList = GetDb.getAllStates();
            session.setAttribute("stateList", stateList);
            session.setAttribute("customer", customer);
            urlString = "/newPet.jsp";
        }
        return urlString;
    }
    private String doEditCustomer(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<DispositionType> dispoList = GetDb.getAllDispositions();
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        List<PetType> petTypeList = GetDb.getAllPetTypes();
        String urlString;
        String customerId = request.getParameter("customerId");
        Customer customer = GetDb.getCustomerById(customerId);
        
        urlString = "/updateCustomer.jsp";
        
        request.setAttribute("genderList", genderList);
        request.setAttribute("customer", customer);
        
        return urlString;
    }
    private String doEditFoundPet(HttpServletRequest request, HttpServletResponse response){
        String urlString;
        String petIdString = request.getParameter("petId");
        int petId = Integer.valueOf(petIdString);
        Pet pet = GetDb.getPetById(petId);
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        pet.setPetTypeString(GetDb.getPetTypeDesc(pet.getPetTypeId()));
        String customerId = String.valueOf(pet.getCustomerId());
        pet.setUnformattedDate();
        Customer customer = GetDb.getCustomerById(customerId);
        
        request.setAttribute("customer", customer);
        request.setAttribute("genderList", genderList);
        request.setAttribute("petId", petId);
        request.setAttribute("pet", pet);
        
        urlString = "/updatePet.jsp";
        
        return urlString;
    }
    private String doEditPet(HttpServletRequest request, HttpServletResponse response){
        String urlString;
        String petIdString = request.getParameter("petId");
        int petId = Integer.valueOf(petIdString);
        Pet pet = GetDb.getPetById(petId);
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        pet.setPetTypeString(GetDb.getPetTypeDesc(pet.getPetTypeId()));
        pet.setUnformattedDate();
        
        request.setAttribute("genderList", genderList);
        request.setAttribute("petId", petId);
        request.setAttribute("pet", pet);
        
        urlString = "/updatePet.jsp";
        
        return urlString;
    }
    private String doFindCustomer(HttpServletRequest request, HttpServletResponse response){
        
        
        String urlString = "";
        Customer customer = new Customer();
        String searchType= request.getParameter("searchType");        
        String userInput = request.getParameter("customerSearch");
        String phone = "";       
        String lastName = "";
        phone = userInput;
        lastName = userInput;
        switch(searchType){
            case "phone":         
                if(phone != "" && ValidatorUtil.isPositiveWholeNumber(phone) && phone.length() == 10){
                customer = GetDb.getCustomerByPhone(phone);
                if(customer != null){
                    urlString = "/findCustomer.jsp";  
                    String stateString = GetDb.getStateDesc(customer.getStateId());
                    customer.setState(stateString);
                    customer.setIsActiveString(customer.getIsActiveString());
                    request.setAttribute("customer", customer);
                }
                else{
                    request.setAttribute("phone", phone);
                    urlString = "/newCustomer.jsp";
                    }
                }
                else {
                    String message = "Please enter a valid phone number";
                    request.setAttribute("message", message);
                    urlString = "/search.jsp";
                }
                break;
            case "lastName":
                if(lastName != "" && ValidatorUtil.isAlphabetic(lastName)){
                customer = GetDb.getCustomerByLastName(lastName);
                if(customer != null){
                    urlString = "/findCustomer.jsp";    
                    String stateString = GetDb.getStateDesc(customer.getStateId());
                    customer.setState(stateString);
                    customer.setIsActiveString(customer.getIsActiveString());
                    request.setAttribute("customer", customer);
                }
                else{
                    request.setAttribute("lastName", lastName);
                    urlString = "/newCustomer.jsp";
                    }
                }
                else {
                    String message = "Please enter a valid last name";
                    request.setAttribute("message", message);
                    urlString = "/search.jsp";
                }
                break;
            case "getAllCustomers":
                List<Customer> customerList = GetDb.getAllCustomers();
                urlString = "/findAllCustomers.jsp";
                request.setAttribute("customer", customer);
                request.setAttribute("customerList", customerList);
                break;
            }
        
        
        return urlString;
    }
    private String doNewCustomer(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
 
        List<DispositionType> dispoList = GetDb.getAllDispositions();
        List<GenderEnum> genderList = Arrays.asList(GenderEnum.values());
        List<PetType> petTypeList = GetDb.getAllPetTypes();
        
        Customer customer = new Customer();
        Random r = new Random();
        int random = r.nextInt();
        String urlString = "";
        String message = "";
        int lastId = 0;
        
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String stateIdString = request.getParameter("state");
        int stateId = Integer.valueOf(stateIdString);
        String stateString = GetDb.getStateDesc(stateId);
        String zipCode = request.getParameter("zipCode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String comments = request.getParameter("comments");
        
        
        if(ValidatorUtil.isAlphabetic(firstName) && ValidatorUtil.isAlphabetic(lastName)
                && ValidatorUtil.hasText(address) && ValidatorUtil.isValidZipCode(zipCode)
                ){
            
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("phone", phone);
            session.setAttribute("email", email);
            session.setAttribute("customerId", lastId);
            session.setMaxInactiveInterval(-1);
           
            
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setStateId(stateId);
            customer.setState(stateString);
            customer.setZipCode(zipCode);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setComments(comments);
            
            lastId = DbInserts.insertCustomer(customer);
            
            customer = GetDb.getCustomerByPhone(phone);
           
            
            request.setAttribute("customerId", lastId);
            request.setAttribute("petTypeList", petTypeList);
            request.setAttribute("genderList", genderList);
            request.setAttribute("dispoList", dispoList);
            
            
            session.setAttribute("petTypeList", petTypeList);
            session.setAttribute("genderList", genderList);
            session.setAttribute("dispoList", dispoList);
            
            session.setAttribute("customer", customer);
            request.setAttribute("customer", customer);
             urlString = "/newPet.jsp";
        }
        else{
            message = "please enter all required fields";
            urlString = "/newCustomer.jsp";
        }
            if(phone.length() < 10 || phone.length() > 10){
                message = "please enter a 10 digit phone number";
                urlString = "/newCustomer.jsp";
            }
        request.setAttribute("message", message);
       return urlString;
    }
    
    private String doNewPet(HttpServletRequest request, HttpServletResponse response){
           List<StateType> stateList = GetDb.getAllStates();
        
            HttpSession session = request.getSession();
            
            
            Customer customer = (Customer) session.getAttribute("customer");
            Pet pet = new Pet();
            String urlString = "";
            String message = "";
            
            if(customer == null){
                message = "couldn't find customer please re-enter information";
                urlString = "/search.jsp";
            }
            else{
            int customerId = customer.getCustomerId();
                
            
           String petName = request.getParameter("petName");
           String petTypeString = request.getParameter("petType");
           int petTypeId = Integer.valueOf(petTypeString);
           String petGender = request.getParameter("petGender");
           String petDOB = request.getParameter("petDOB");
           String petDispositionString = request.getParameter("petDisposition".toString());
           int petDisposition = Integer.valueOf(petDispositionString);
           String kennelCoughDate = request.getParameter("kennelCoughDate");
           String breed = request.getParameter("breed");
           String comments = request.getParameter("comments");
           
        if(ValidatorUtil.isAlphabetic(petName) && ValidatorUtil.hasText(petDOB) 
               && ValidatorUtil.isAlphabetic(breed) && ValidatorUtil.hasText(kennelCoughDate) ){
               
            
           session.setAttribute("petName", petName);
           session.setAttribute("petType", petTypeString);
           session.setAttribute("petGender", petGender);
           session.setAttribute("petDOB", petDOB);
           session.setAttribute("petDisposition", petDisposition);
           session.setAttribute("kennelCoughDate", kennelCoughDate);
           session.setAttribute("breed", breed);
           session.setAttribute("comments", comments);
           session.setAttribute("stateList", stateList);
           session.setMaxInactiveInterval(-1);
            
            pet.setCustomerId(customerId);
            pet.setPetName(petName);
            pet.setPetGender(petGender);
            pet.setPetDispositionId(petDisposition);
            
            pet.setPetDispositionString(GetDb.getDispoDesc(Integer.valueOf(petDisposition)));
            
            pet.setPetDOB(petDOB);
            pet.setPetTypeId(petTypeId);
            pet.setBreed(breed);
            pet.setKennelCoughDate(kennelCoughDate);
            pet.setComments(comments);        
            
            request.setAttribute("pet", pet);
            session.setAttribute("pet", pet);
            urlString = "/userDisplay.jsp";
            
            if(StevesDate.validateDate(petDOB) == true && StevesDate.validateKennelCoughDate(kennelCoughDate) == true){
                DbInserts.insertPet(pet);            
            }
            else{
                message = "please enter correct date format";
                urlString = "/newPet.jsp";
            
            }
            }        
        else{
            urlString = "/newPet.jsp";
            message = "please enter correct input";
        }
    }    
        
                
        request.setAttribute("message", message);
        return urlString;
    }
    private String doUpdatePet(HttpServletRequest request, HttpServletResponse response){
           List<StateType> stateList = GetDb.getAllStates();
           
        
            HttpSession session = request.getSession();
            
            
            Customer customer = (Customer) session.getAttribute("customer");
            Pet pet = new Pet();
            String urlString = "";
            String message = "";
            
            if(customer == null){
                message = "couldn't find customer please re-enter information";
                urlString = "/search.jsp";
            }
            else{
            int customerId = customer.getCustomerId();
                 
           String petIdString = request.getParameter("petId");
           int petId = Integer.valueOf(petIdString);
           String petName = request.getParameter("petName");
           String petTypeString = request.getParameter("petType");
           int petTypeId = Integer.valueOf(petTypeString);
           String petGender = request.getParameter("petGender");
           String petDOB = request.getParameter("petDOB");
           String petDispositionString = request.getParameter("petDisposition");
           int petDispositionId = Integer.valueOf(petDispositionString);
           
           String kennelCoughDate = request.getParameter("kennelCoughDateString");
           String breed = request.getParameter("breed");
           String comments = request.getParameter("comments");
           
        if(ValidatorUtil.isAlphabetic(petName) && ValidatorUtil.hasText(petDOB) 
               && ValidatorUtil.isAlphabetic(breed) && ValidatorUtil.hasText(kennelCoughDate) ){
               
           session.setAttribute("petId", petId);
           session.setAttribute("petName", petName);
           session.setAttribute("petType", petTypeString);
           session.setAttribute("petGender", petGender);
           session.setAttribute("petDOB", petDOB);
           session.setAttribute("petDisposition", petDispositionId);
           session.setAttribute("kennelCoughDate", kennelCoughDate);
           session.setAttribute("breed", breed);
           session.setAttribute("comments", comments);
           session.setAttribute("stateList", stateList);
           session.setMaxInactiveInterval(-1);
            
            pet.setPetId(petId);
            pet.setCustomerId(customerId);
            pet.setPetName(petName);
            pet.setPetGender(petGender);
            pet.setPetDispositionId(petDispositionId);
            pet.setPetDispositionString(GetDb.getDispoDesc(Integer.valueOf(petDispositionId)));
            pet.setPetTypeId(petTypeId);
            pet.setPetDOB(petDOB);
            pet.setBreed(breed);
            pet.setKennelCoughDate(kennelCoughDate);
            pet.setComments(comments);
            pet.setUnformattedDate();
            
            
            
            request.setAttribute("pet", pet);
            session.setAttribute("pet", pet);
            urlString = "/userDisplay.jsp";
            
            if(StevesDate.validateDate(petDOB) == true && StevesDate.validateKennelCoughDate(kennelCoughDate) == true){
                UpdateDb.updatePet(pet);
            }
            else{
                request.setAttribute("kennelCoughString", pet.getKennelCoughDate());
                message = "please enter correct date format";
                urlString = "/updatePet.jsp";
            
            }
            }        
        else{
            urlString = "/updatePet.jsp";
            message = "please enter correct input";
        }
    }    
        
                
        request.setAttribute("message", message);
        return urlString;
    }
    private void loadCustomerPageData(HttpServletRequest request) {
        
        
        List<StateType> stateList = GetDb.getAllStates();
        
        
        HttpSession session = request.getSession();
            
        session.setAttribute("stateList", stateList);
       
                
    }
    
    private void loadPetPageData(HttpServletRequest request) {
        
        
        List<DispositionType> dispoList = GetDb.getAllDispositions();
        
        HttpSession session = request.getSession();
            
        session.setAttribute("dispList", dispoList);
       
                
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
