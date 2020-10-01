/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class AddRoomGroupDetails extends AbstractTableModel {
    
     private static final String[] COLUMN_NAMES = {
         "Id",
        "Sub Group No"
       
    };
    
    private static ArrayList<AllocationsModel> list;

    AddRoomGroupDetails(ArrayList<AllocationsModel> sList) {
        list = sList;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getaSid();
            case 1:
                return list.get(rowIndex).getSubGroupNo();
            
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}


