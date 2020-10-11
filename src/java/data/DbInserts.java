/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;;

import business.DispositionType;
import business.PetType;
import business.StateType;
import business.Customer;
import business.Pet;
import business.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
/**
 *
 * @author hecks
 */
public class DbInserts {
    
    public static void insertEmployee(Employee employee){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        
    try{
        String preparedQuery = 
                "INSERT INTO employee (first_name, last_name, user_name, role_type_id, salt, hash_pass, active, date_added) "
                + "VALUES (?,?,?,?,?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUserName());
            ps.setInt(4, employee.getRoleTypeId());
            ps.setString(5, employee.getSaltPassword());
            ps.setString(6, employee.getHashPassword());
            ps.setInt(7, 1);
            ps.setDate(8, date);
        
            ps.executeUpdate();
    }
    
        catch(SQLException e){
            System.out.println("insertEmployee: "+ e);
            
        }
                 
    }
    public static void insertPet(Pet pet){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        
    try{
        String preparedQuery = 
                "INSERT INTO pet(customer_id, pet_name, gender, pet_type_id, "
                + "month_year_born, disposition_type_id, date_last_kennel_cough, breed, comments, date_added)"
                + "VALUES (?,?,?,?,?,?, DATE ?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setInt(1, pet.getCustomerId());
            ps.setString(2, pet.getPetName());
            ps.setString(3, pet.getPetGender());
            ps.setInt(4, pet.getPetTypeId());
            ps.setString(5, pet.getPetDOB());
            ps.setInt(6, pet.getPetDispositionId());
            ps.setString(7, pet.getFormattedDate());
            ps.setString(8, pet.getBreed());
            ps.setString(9, pet.getComments());
            ps.setDate(10, date);
        
            ps.executeUpdate();
    }
    
        catch(SQLException e){
            System.out.println("insertPet: "+ e);
            
        }
                 
    }
    public static void insertDispo(DispositionType dispoType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        
    try{
        String preparedQuery = 
                "INSERT INTO disposition_type(short_desc, long_desc, active, date_added) "
                + "VALUES (?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, dispoType.getShortDesc());
            ps.setString(2, dispoType.getLongDesc());
            ps.setInt(3, dispoType.getIsActive());
            ps.setDate(4, date);
        
            ps.executeUpdate();
    }
    
        catch(SQLException e){
            System.out.println("insertDispo: "+ e);
            
        }
                 
    }
    public static void insertPetType(PetType petType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        
    try{
        String preparedQuery = 
                "INSERT INTO pet_type(short_desc, long_desc, active, date_added) "
                + "VALUES (?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, petType.getShortDesc());
            ps.setString(2, petType.getLongDesc());
            ps.setInt(3, petType.getIsActive());
            ps.setDate(4, date);
        
            ps.executeUpdate();
    }
    
        catch(SQLException e){
            System.out.println("insertPetType: "+ e);
            
        }
                 
    }
    public static void insertStateType(StateType stateType){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        
    try{
        String preparedQuery = 
                "INSERT INTO state_list(short_desc, long_desc, active, date_added) "
                + "VALUES (?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, stateType.getShortDesc());
            ps.setString(2, stateType.getLongDesc());
            ps.setInt(3, stateType.getIsActive());
            ps.setDate(4, date);
        
            ps.executeUpdate();
    }
    
        catch(SQLException e){
            System.out.println("insertState: "+ e);
            
        }
                 
    }
    public static int insertCustomer(Customer customer){
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        long millis = System.currentTimeMillis();  
        Date date = new java.sql.Date(millis);
        int id = 0;
    try{
        String preparedQuery = 
                "INSERT INTO customer(first_name, last_name, phone, email, "
                + "street_address, city, state_id, postal_code, comments, date_added)" 
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
                
        PreparedStatement ps = connection.prepareStatement(preparedQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getCity());
            ps.setInt(7, customer.getStateId());
            ps.setString(8, customer.getZipCode());
            ps.setString(9, customer.getComments());
            ps.setDate(10, date);
        
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                id = rs.getInt(1);
            }
            
    }
    
        catch(SQLException e){
            System.out.println("insertCustomer: "+ e);
            
        }
   return id;
    }
}
