/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author hecks
 */
public class Employee implements Serializable{
    private int employeeId;
    private String firstName;
    private String lastName;
    private String userName;
    private int roleTypeId;    
    private String hashPassword;
    private String saltPassword;
    private int isActive;

    public Employee() {
    
    }
    
    public Employee(int id, String firstName, String lastName, int roleTypeId, String hashPassword, String saltPassword, int isActive){
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleTypeId = roleTypeId;
        this.hashPassword = hashPassword;
        this.saltPassword = saltPassword;
        this.isActive = isActive;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
public int getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(int roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getSaltPassword() {
        return saltPassword;
    }

    public void setSaltPassword(String saltPassword) {
        this.saltPassword = saltPassword;
    }
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    public int getIsActive() {
        return isActive;
    }   
    public String getRoleTypeString(){
        String roleTypeString = "";
        if(roleTypeId == 1){
            roleTypeString = "System Administrator";
        }
        else if(roleTypeId == 2){
            roleTypeString = "System Developer";
        }
        else if(roleTypeId == 3){
            roleTypeString = "Staff Employee";
        }
        return roleTypeString;
    }
}
