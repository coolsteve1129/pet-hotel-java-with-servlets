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
public class Pet implements Serializable {
    private int petId;
    private int customerId;
    private String petName;
    private String petGender;
    private String petDOB;
    private int petDispositionId;
    private String petDispositionString;
    private int petTypeId;
    private String petTypeString;
    private String kennelCoughDate;
    private String comments;
    private String breed;
    private int isActive;
    private String unformattedDate;
    private String isActiveString;
    

    public Pet(){
        
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getIsActiveString() {
        String isActiveString = "";
        
        if(isActive == 1){
            isActiveString = "Active";
        }
        else{
            isActiveString = "Deleted";
        }
        return isActiveString;
    }

    public void setIsActiveString(String isActiveString) {
        this.isActiveString = isActiveString;
    }
    
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getPetDispositionString() {
        return petDispositionString;
    }

    public void setPetDispositionString(String petDispositionString) {
        this.petDispositionString = petDispositionString;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public Integer getPetDispositionId() {
        return petDispositionId;
    }
    public void setPetDispositionId(Integer petDisposition) {
        this.petDispositionId = petDisposition;
    }
    public String getKennelCoughDate() {
        return kennelCoughDate;
    }

    public void setKennelCoughDate(String kennelCoughDate) {
        this.kennelCoughDate = kennelCoughDate;
    }
    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetTypeString() {
        return petTypeString;
    }

    public void setPetTypeString(String petTypeString) {
        this.petTypeString = petTypeString;
    }
    
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPetDOB() {
        return petDOB;
    }

    public void setPetDOB(String petDOB) {
        this.petDOB = petDOB;
    }
    public String getFormattedDate(){
        String formattedDate = "";
        
        String[] arr = kennelCoughDate.split("/");
        
        String month = arr[0];
        String day = arr[1];
        String year = arr[2];
        
        formattedDate = year +"/"+ month +"/"+ day  ;
        return formattedDate;
    }
    public void setUnformattedDate(){
        this.unformattedDate = getUnformattedDate();
    }
    public String getUnformattedDate(){
        String formattedDate = kennelCoughDate;
        String subString = formattedDate.substring(4, 5);
    if( !"-".equals(subString)){
        String[] arr = formattedDate.split("/");
        
        String month = arr[0];
        String day = arr[1];
        String year =  arr[2];
        
        unformattedDate =  month +"/" +day +"/" +year ;
    }
    else{
        
        String[] arr = formattedDate.split("-");
        
        String year = arr[0];
        String month = arr[1];
        String day =  arr[2];
        
        unformattedDate =  month +"/" +day +"/" +year ;
    }
        return unformattedDate;
    }
   
    public String getFormattedGender(){
        String formattedGender = "";
        
        String firstLetter = petGender.substring(0, 1);
        String restOfWord = petGender.substring(1).toLowerCase();
        
        formattedGender = firstLetter + restOfWord;
        
        return formattedGender;
    }
}
