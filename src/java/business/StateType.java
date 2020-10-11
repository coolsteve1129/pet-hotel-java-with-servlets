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
public class StateType implements Serializable{
    private int stateId;
    private String shortDesc;
    private String longDesc;
    private int isActive;

    public StateType() {
    
    }
    
    public StateType(int id, String shortDesc, String longDesc, int isActive){
        this.stateId = id;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.isActive = isActive;
    }
    
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
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

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
public int getIsActive() {
        return isActive;
    }   
}
