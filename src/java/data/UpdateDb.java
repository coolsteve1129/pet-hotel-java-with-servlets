/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Customer;
import business.DispositionType;
import business.PetType;
import business.StateType;
import business.Pet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hecks
 */
public class UpdateDb {
    public static void updateCustomer(Customer customer){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
    try{
        String preparedQuery = 
                "UPDATE customer SET " 
                + "first_name = ?, last_name = ?, phone = ?, email = ?, "
                + "street_address = ?, city = ?, state_id = ?, postal_code = ?, "
                + "comments = ?, date_modified = ? "
                + "WHERE id = ?"; 
                
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getCity());
            ps.setString(7, customer.getState());
            ps.setString(8, customer.getZipCode());
            ps.setString(9, customer.getComments());
            ps.setDate(10, date);
            ps.setInt(11, customer.getCustomerId());
            
        
            ps.executeUpdate();
            
            
    }
    
        catch(SQLException e){
            System.out.println("updateCustomer: "+ e);
            
        }
    }
    public static void updateDispoType(DispositionType dispoType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
    try{
        String preparedQuery = 
                "UPDATE disposition_type SET " 
                + "short_desc = ?, long_desc = ?, active = ?, date_modified = ? "
                + "WHERE id = ?"; 
                
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
           
            ps.setString(1, dispoType.getShortDesc());
            ps.setString(2, dispoType.getLongDesc());
            ps.setInt(3, dispoType.getIsActive());
            ps.setDate(4, date);
            ps.setInt(5, dispoType.getDispoId());
        
            ps.executeUpdate();  
        }
            catch(SQLException e){
            System.out.println("updateDispoType: "+ e);
            
        }
    }
    public static void updatePetType(PetType petType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
    try{
        String preparedQuery = 
                "UPDATE pet_type SET " 
                + "short_desc = ?, long_desc = ?, active = ?, date_modified = ? "
                + "WHERE id = ?"; 
                
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
           
            ps.setString(1, petType.getShortDesc());
            ps.setString(2, petType.getLongDesc());
            ps.setInt(3, petType.getIsActive());
            ps.setDate(4, date);
            ps.setInt(5, petType.getPetTypeId());
        
            ps.executeUpdate();  
        }
            catch(SQLException e){
            System.out.println("updatePetType: "+ e);
            
        }
    }
    public static void updateStateType(StateType stateType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
    try{
        String preparedQuery = 
                "UPDATE state_list SET " 
                + "short_desc = ?, long_desc = ?, active = ?, date_modified = ? "
                + "WHERE id = ?"; 
                
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
           
            ps.setString(1, stateType.getShortDesc());
            ps.setString(2, stateType.getLongDesc());
            ps.setInt(3, stateType.getIsActive());
            ps.setDate(4, date);
            ps.setInt(5, stateType.getStateId());
        
            ps.executeUpdate();  
        }
            catch(SQLException e){
            System.out.println("updateStateType: "+ e);
            
        }
    }
    public static void updatePet(Pet pet){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
    try{
        String preparedQuery = 
                "UPDATE pet SET " 
                + "pet_name = ?, gender = ?, pet_type_id = ?, month_year_born = ?, "
                + "disposition_type_id = ?, date_last_kennel_cough = ?, breed = ?, comments = ?, "
                + "date_modified = ? "
                + "WHERE id = ?"; 
                
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
           
            ps.setString(1, pet.getPetName());
            ps.setString(2, pet.getPetGender());
            ps.setInt(3, pet.getPetTypeId());
            ps.setString(4, pet.getPetDOB());
            ps.setInt(5, pet.getPetDispositionId());
            ps.setString(6, pet.getFormattedDate());
            ps.setString(7, pet.getBreed());
            ps.setString(8, pet.getComments());
            ps.setDate(9, date);
            ps.setInt(10, pet.getPetId());
        
            ps.executeUpdate();  
        }
            catch(SQLException e){
            System.out.println("updatePet: "+ e);
            
        }
    }
}
