/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Steve Heck
 */
public class StevesDate {
    public static boolean validateKennelCoughDate(String date){
        
        int month = 0;
        int day = 0;      
        int year = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        date = date.trim();
        
        if(date.length() < 10)
            return false;
        
        String[] parts = date.split("/");
        if(parts.length != 3)
            return false;
                
    try{
        month = Integer.parseInt(parts[0]);        
    } catch (NumberFormatException e) {
        return false;
    }
    
    try{
        day = Integer.parseInt(parts[1]);
    } catch(NumberFormatException e){
        return false;
    }
    
    try {
        year = Integer.parseInt(parts[2]);
    } catch (NumberFormatException e) {
        return false;
    }
    
    if (month < 1 || month > 12)
        return false;
    
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
        if(day > 31 || day < 1){
            return false;
    }
    }
    if (month == 4 || month == 6 || month == 9 || month == 11){
        if(day > 30 || day < 1){
            return false;
        }
    }
    
    if(month == 2){
        if(year % 4 == 0){
            if(day > 29 || day < 1){
                return false;
            }
        }
        else if(day > 28 || day < 1){
            return false;
        }
    }
    
    
    if (year < 1950 || year > currentYear)
        return false;
    
       
    return true;
    }
    public static boolean validateDate(String date){
         int month = 0;
         int year = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    
        date = date.trim();
        if(date.length() < 7)
            return false;
        
        String[] parts = date.split("/");
        if(parts.length != 2)
            return false;
        
        
    try {
        month = Integer.parseInt(parts[0]);        
    } catch (NumberFormatException e) {
        return false;
    }
    if (month < 1 || month > 12)
        return false;

    try {
        year = Integer.parseInt(parts[1]);
    } catch (NumberFormatException e) {
        return false;
    }
    
    if (year < 1950 || year > currentYear)
        return false;

    return true;
    }
}
