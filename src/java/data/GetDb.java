/* 
 * Copyright 2018 Rene Bylander at WITC
 * Updated on : Nov 9, 2018, 11:32 AM
 */

package data;

import business.DispositionType;
import business.PetType;
import business.StateType;
import business.Customer;
import business.Pet;
import business.RoleType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rene Bylander
 * @created Nov 6, 2017
 */

public class GetDb {
    public static String getDbHashPassword(String userName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String hashPassword = "";
        
        String sql = "Select hash_pass from employee where user_name = ?";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while(rs.next()){
                hashPassword = rs.getString("hash_pass");
            }
        }
        catch(SQLException e){
            System.out.println("getDbHashPassword: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return hashPassword;
    }
    public static String getDbSalt(String userName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String salt = "";
        
        String sql = "Select salt from employee where user_name = ? AND active = 1";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while(rs.next()){
                salt = rs.getString("salt");
            }
        }
        catch(SQLException e){
            System.out.println("getDbSalt: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return salt;
    }
    public static String getDispoDesc(int dropDownIndex){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String longDesc = "";
        
        String sql = "SELECT long_desc FROM disposition_type "
                + "WHERE id = " +dropDownIndex;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                longDesc = rs.getString("long_desc");
            }
        }
        catch(SQLException e){
            System.out.println("getDispoDesc: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return longDesc;
    }
    public static String getDbSalt(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String salt = "";
        
        String sql = "Select salt from employee where hass_pass";
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                salt = rs.getString("salt");
            }
        }
        catch(SQLException e){
            System.out.println("getDbSalt: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return salt;
    }
    public static String getPetTypeDesc(int dropDownIndex){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String longDesc = "";
        
        String sql = "SELECT long_desc FROM pet_type "
                + "WHERE id = " +dropDownIndex;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                longDesc = rs.getString("long_desc");
            }
        }
        catch(SQLException e){
            System.out.println("getDispoDesc: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return longDesc;
    }
    public static String getStateDesc(int dropDownIndex){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String longDesc = "";
        
        String sql = "SELECT long_desc FROM state_list "
                + "WHERE id = " +dropDownIndex;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                longDesc = rs.getString("long_desc");
            }
        }
        catch(SQLException e){
            System.out.println("getStateDesc: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return longDesc;
    }
    
    public static Pet getPetById(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM pet WHERE id = ?";
        try{       
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Pet pet = null;
            if(rs.next()){
                pet = new Pet();
                pet.setPetId(rs.getInt("id"));
                pet.setCustomerId(rs.getInt("customer_id"));
                pet.setPetName(rs.getString("pet_name"));
                pet.setPetGender(rs.getString("gender"));
                pet.setPetTypeId(rs.getInt("pet_type_id"));                
                pet.setPetDOB(rs.getString("month_year_born"));
                pet.setPetDispositionId(rs.getInt("disposition_type_id"));
                pet.setKennelCoughDate(rs.getString("date_last_kennel_cough"));
                pet.setBreed(rs.getString("breed"));
                pet.setComments(rs.getString("comments"));
            }
            return pet;
        }
        catch(SQLException e){
            System.out.println("getPetById: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static Pet getPetByCustomerId(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM pet WHERE customer_id = ?";
        try{       
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Pet pet = null;
            if(rs.next()){
                pet = new Pet();
                pet.setPetId(rs.getInt("id"));
                pet.setCustomerId(rs.getInt("customer_id"));
                pet.setPetName(rs.getString("pet_name"));
                pet.setPetGender(rs.getString("gender"));
                pet.setPetTypeId(rs.getInt("pet_type_id"));
                pet.setPetDOB(rs.getString("month_year_born"));
                pet.setPetDispositionId(rs.getInt("disposition_type_id"));
                pet.setKennelCoughDate(rs.getString("date_last_kennel_cough"));
                pet.setBreed(rs.getString("breed"));
                pet.setComments(rs.getString("comments"));
                pet.setIsActive(rs.getInt("active"));
                pet.setIsActiveString(pet.getIsActiveString());
            }
            return pet;
        }
        catch(SQLException e){
            System.out.println("getPetByCustomerId: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static Customer getCustomerById(String id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM customer WHERE id = ?";
        try{       
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            Customer customer = null;
            if(rs.next()){
                customer = new Customer();
                customer.setCustomerId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("street_address"));
                customer.setCity(rs.getString("city"));
                customer.setStateId(rs.getInt("state_id"));
                customer.setState(getStateDesc(customer.getStateId()));
                customer.setZipCode(rs.getString("postal_code"));  
                customer.setComments(rs.getString("comments"));
               
            }
            return customer;
        }
        catch(SQLException e){
            System.out.println("getCustomerById: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static Customer getCustomerByLastName(String lastName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM customer WHERE last_name = ?";
        try{       
            ps = connection.prepareStatement(sql);
            ps.setString(1, lastName);
            rs = ps.executeQuery();
            Customer customer = null;
            if(rs.next()){
                customer = new Customer();
                customer.setCustomerId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("street_address"));
                customer.setCity(rs.getString("city"));
                customer.setStateId(rs.getInt("state_id"));
                customer.setState(getStateDesc(customer.getStateId()));
                customer.setZipCode(rs.getString("postal_code"));   
                customer.setComments(rs.getString("comments"));
                customer.setIsActive(rs.getInt("active")); }
            return customer;
        }
        catch(SQLException e){
            System.out.println("getCustomerByLastName: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static Customer getCustomerByPhone(String phone){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM customer WHERE phone = ?";
        try{       
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            Customer customer = null;
            if(rs.next()){
                customer = new Customer();
                customer.setCustomerId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("street_address"));
                customer.setCity(rs.getString("city"));
                customer.setStateId(rs.getInt("state_id"));
                customer.setState(getStateDesc(customer.getStateId()));
                customer.setZipCode(rs.getString("postal_code"));   
                customer.setComments(rs.getString("comments"));
                customer.setIsActive(rs.getInt("active"));               
            }
            return customer;
        }
        catch(SQLException e){
            System.out.println("getCustomerByPhone: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static List<PetType> getAllPetTypes(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PetType> petTypeList = new ArrayList<>();
        
        String sql = "SELECT id, short_desc, long_desc, active FROM pet_type";        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                PetType petType = new PetType();
                petType.setPetTypeId(rs.getInt("id"));
                petType.setShortDesc(rs.getString("short_desc"));
                petType.setLongDesc(rs.getString("long_desc"));
                petType.setIsActive(rs.getInt("active"));
                petTypeList.add(petType);
            }
        }
        catch(SQLException e){
            System.out.println("getAllPetTypes: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return petTypeList;       
    }
    public static List<Customer> getAllCustomers(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customer> customerList = new ArrayList<>();
        
        String sql = "SELECT * FROM customer";        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("street_address"));
                customer.setCity(rs.getString("city"));
                customer.setStateId(rs.getInt("state_id"));
                customer.setState(getStateDesc(customer.getStateId()));
                customer.setZipCode(rs.getString("postal_code"));
                customer.setComments(rs.getString("comments"));
                customer.setIsActive(rs.getInt("active"));
                
                
                customerList.add(customer);
            }
        }
        catch(SQLException e){
            System.out.println("getAllCustomers: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return customerList;       
    }
    public static List<Pet> getAllPets(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petList = new ArrayList<>();
        
        String sql = "SELECT * FROM pet";        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet pet = new Pet();
                
                pet.setPetId(rs.getInt("id"));
                pet.setPetName(rs.getString("pet_name"));
                pet.setPetGender(rs.getString("gender"));
                pet.setPetTypeId(rs.getInt("pet_type_id"));
                pet.setPetTypeString(getPetTypeDesc(pet.getPetTypeId()));
                pet.setPetDOB(rs.getString("month_year_born"));
                pet.setPetDispositionId(rs.getInt("disposition_type_id"));
                pet.setPetDispositionString(GetDb.getDispoDesc(pet.getPetDispositionId()));
                pet.setKennelCoughDate(rs.getString("date_last_kennel_cough"));
                pet.setBreed(rs.getString("breed"));
                pet.setComments(rs.getString("comments"));
                pet.setIsActive(rs.getInt("active"));
                
                
                petList.add(pet);
            }
        }
        catch(SQLException e){
            System.out.println("getAllPets: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return petList;       
    }
    public static List<Pet> getPetsByCustomerId(int customerId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pet> petList = new ArrayList<>();
        
        String sql = "SELECT * FROM pet WHERE customer_id = ?";        
        try{
            ps = connection.prepareStatement(sql);
                ps.setInt(1, customerId);
            rs = ps.executeQuery();
            while(rs.next()){
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("id"));
                pet.setPetName(rs.getString("pet_name"));
                pet.setPetGender(rs.getString("gender"));
                pet.setPetTypeId(rs.getInt("pet_type_id"));
                pet.setPetTypeString(getPetTypeDesc(pet.getPetTypeId()));
                pet.setPetDOB(rs.getString("month_year_born"));
                pet.setPetDispositionId(rs.getInt("disposition_type_id"));
                pet.setPetDispositionString(GetDb.getDispoDesc(pet.getPetDispositionId()));
                pet.setKennelCoughDate(rs.getString("date_last_kennel_cough"));
                pet.setBreed(rs.getString("breed"));
                pet.setComments(rs.getString("comments"));
                pet.setIsActive(rs.getInt("active"));
                
                
                petList.add(pet);
            }
        }
        catch(SQLException e){
            System.out.println("getPetsByCustomerId: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return petList;       
    }
    public static List<StateType> getAllStates(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StateType> stateList = new ArrayList<>();
        
        String sql = "SELECT id, short_desc, long_desc, active FROM state_list";        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                StateType stateType = new StateType();
                stateType.setStateId(rs.getInt("id"));
                stateType.setShortDesc(rs.getString("short_desc"));
                stateType.setLongDesc(rs.getString("long_desc"));
                stateType.setIsActive(rs.getInt("active"));
                stateList.add(stateType);
            }
        }
        catch(SQLException e){
            System.out.println("getAllStates: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return stateList;       
    }
    public static List<DispositionType> getAllDispositions(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DispositionType> dispoList = new ArrayList<>();
        
        String sql = "SELECT id, short_desc, long_desc, active "
                + "FROM disposition_type";
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DispositionType dispoType = new DispositionType();
                dispoType.setDispoId(rs.getInt("id"));
                dispoType.setShortDesc(rs.getString("short_desc"));
                dispoType.setLongDesc(rs.getString("long_desc"));
                dispoType.setIsActive(rs.getInt("active"));
                dispoList.add(dispoType);                   
            }
        }
        catch(SQLException e){
            System.out.println("getAllDispositions: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return dispoList;
    }
    
    public static List<RoleType> getAllRoleTypes() {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RoleType> employeeRoleList = new ArrayList<>();
        
        String sql = "SELECT id, short_desc, long_desc, active FROM role_type";        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                RoleType roleType = new RoleType();
                roleType.setRoleTypeId(rs.getInt("id"));
                roleType.setShortDesc(rs.getString("short_desc"));
                roleType.setLongDesc(rs.getString("long_desc"));
                roleType.setIsActive(rs.getInt("active"));
                employeeRoleList.add(roleType);
            }
        }
        catch(SQLException e){
            System.out.println("getAllEmployeeRoles: " + e);
            return null;
        }
        finally{
            DbHelper.closeResultSet(rs);
            DbHelper.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return employeeRoleList;   
    }
  

}
