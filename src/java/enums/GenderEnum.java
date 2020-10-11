/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Steve Heck
 */
public enum GenderEnum {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");
    private String gender;
    private GenderEnum(String gender){
        this.gender = gender;
    }
        public String getGender(){
            return gender;
        }
    
}
