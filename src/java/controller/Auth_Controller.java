/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.GetDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.PasswordUtil;
import utility.ValidatorUtil;

/**
 *
 * @author hecks
 */
public class Auth_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            getServletContext().getRequestDispatcher(url)
                .forward(request, response);
        }
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
        
        HttpSession session = request.getSession();
        String sessionUserName = (String) session.getAttribute("user_name");
        String action = request.getParameter("action");
        String url = "";
            loadCustomerPageData(request);
                
        if (action.equals("manage")){   
            if(ValidatorUtil.hasText(sessionUserName)){         
                url = "/admin/chooseManageType.jsp";
            }
            else{                               
                url = "/admin/login.jsp";   
            }
        }
        processRequest(request, response, url);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";        
        int stateId = 0;
    
        if(action.equals("login")){
            url = doLogin(request, response);
        }
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
private String doLogin(HttpServletRequest request, HttpServletResponse response) {
        
    
        HttpSession session = request.getSession();
           session.setMaxInactiveInterval(-1);
        
        String urlString = "/admin/login_error.jsp";
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String saltedUserPassword = "";
        String hashedUserPassword = "";
        String passwordSalt = GetDb.getDbSalt(userName);
        String hashPassword = GetDb.getDbHashPassword(userName);
        
        saltedUserPassword = passwordSalt.concat(password);
        try{
            hashedUserPassword = PasswordUtil.hashPassword(saltedUserPassword);
        }
        catch(NoSuchAlgorithmException e){
            System.out.println();
        }   
        if(hashedUserPassword.equals(hashPassword)){
            urlString = "/admin/chooseManageType.jsp";
            session.setAttribute("user_name", userName);
        }
        
        return urlString;
    }
private void loadCustomerPageData(HttpServletRequest request) {
        
        
        
        HttpSession session = request.getSession();
            
        
                
    }
}
