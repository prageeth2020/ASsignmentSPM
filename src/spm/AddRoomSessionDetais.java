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
public class AddRoomSessionDetais extends AbstractTableModel {
    
     private static final String[] COLUMN_NAMES = {
         "Id",
        "Lec Name",
        "Subject Name",
        "Subject Code",
        "Tag",
        "Sub Group Id"
       
    };
    
    private static ArrayList<AllocationsModel> list;

    AddRoomSessionDetais(ArrayList<AllocationsModel> sList) {
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
                return list.get(rowIndex).getSessionRID();
            case 1:
                return list.get(rowIndex).getEmpName();
            case 2:
                return list.get(rowIndex).getSubName();
            case 3:
                return list.get(rowIndex).getSubCode();
            case 4:
                return list.get(rowIndex).getTag();
            case 5:
                return list.get(rowIndex).getSubGroupNo();   
            
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}



