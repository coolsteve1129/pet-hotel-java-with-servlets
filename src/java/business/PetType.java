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
public class PetType implements Serializable{

    private int petTypeId;
    private String shortDesc;
    private String longDesc;
    private int isActive;

    
    public PetType(int petTypetId, String shortDesc, String longDesc, int isActive) {
        this.petTypeId = petTypeId;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.isActive = isActive;
    }
    
    public PetType() {
    
    }
    
    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
