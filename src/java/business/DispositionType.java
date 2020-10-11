/* 
 * Copyright 2017 Rene Bylander at WITC
 */

package business;

import java.io.Serializable;

/**
 * @author Rene Bylander
 * @created Sep 14, 2017
 */
public class DispositionType implements Serializable{
    private int dispoId;
    private String shortDesc;
    private String longDesc;
    private int isActive;
    
    
    public DispositionType(){
       
    }//end of constructor
    
    public DispositionType(int id, String shortDesc, String longDesc, int isActive){
        this.dispoId = id;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.isActive = isActive;
    }

    public void setDispoId(int dispoId) {
        this.dispoId = dispoId;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public int getDispoId() {
        return dispoId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
public int getIsActive() {
        return isActive;
    }   
  



}//end of class
