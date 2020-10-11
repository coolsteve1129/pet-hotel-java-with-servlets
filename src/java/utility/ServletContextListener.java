/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContextEvent;
import business.DispositionType;
import business.PetType;
import business.StateType;
import data.GetDb;
import java.util.List;

import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author hecks
 */
public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        ServletContext sc = event.getServletContext();
        
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);
        
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
        
            List<DispositionType> dispoList = GetDb.getAllDispositions();
            List<StateType> stateTypeList = GetDb.getAllStates();
            List<PetType> petTypeList = GetDb.getAllPetTypes();
            sc.setAttribute("dispoList", dispoList);
            sc.setAttribute("petTypeList", petTypeList);
            sc.setAttribute("stateList", stateTypeList);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
        ServletContext sc = event.getServletContext();
        sc.removeAttribute("dispoList");
        sc.removeAttribute("petTypeList");
        sc.removeAttribute("stateList");
    }
}
