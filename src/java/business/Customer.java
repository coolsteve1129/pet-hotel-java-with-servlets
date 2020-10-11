/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author Steve Heck
 */
public class Customer implements Serializable {
   private int customerId;
   private String firstName;
   private String lastName;
   private String address;
   private String city;
   private String state;
   private int stateId;
   private String zipCode;
   private String email;
   private String phone;
   private String comments;
   private int isActive;
   private String isActiveString;
   

   
    public Customer(){
    
    }

    public Integer getIsActive() {
        return isActive;
    }


    public void setIsActiveString(String isActiveString) {
        this.isActiveString = isActiveString;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
   
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
    
    

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFormattedPhone(){
        String unformattedPhone = phone;
        String formattedPhone = unformattedPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        
        return formattedPhone;
    }
    public String getFormattedPhoneString(){
        return getFormattedPhone();
    }
    public String getIsActiveString(){
        String isActiveString = "";
        
        if(isActive == 1){
            isActiveString = "Active";
        }
        else{
            isActiveString = "Deleted";
        }
        return isActiveString;
    }
}

