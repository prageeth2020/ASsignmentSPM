/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class AddRoomSubDetails extends AbstractTableModel {
    
     private static final String[] COLUMN_NAMES = {
         "Id",
        "Subject Name"
       
    };
    
    private static ArrayList<AddSubRoomModel> list;

    AddRoomSubDetails(ArrayList<AddSubRoomModel> sList) {
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
                return list.get(rowIndex).getSubID();
            case 1:
                return list.get(rowIndex).getSubName();
            
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}
