/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

/**
 *
 * @author User
 */
public class AddSubRoomModel {
    
     private String subName;
      private int subID;
      public String toString() {
        return "name "+this.subName + "Id "+ this.subID ;
        }
    /**
     * @return the subName
     */
    public String getSubName() {
        return subName;
    }

    /**
     * @param subName the subName to set
     */
    public void setSubName(String subName) {
        this.subName = subName;
    }

    /**
     * @return the subID
     */
    public int getSubID() {
        return subID;
    }

    /**
     * @param subID the subID to set
     */
    public void setSubID(int subID) {
        this.subID = subID;
    }
    
}
