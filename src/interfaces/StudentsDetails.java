package interfaces;

import javax.swing.*;
import java.awt.*;

public class StudentsDetails {
    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Declare the Jlabels
        JLabel studentLbl1 , studentLbl2 , studentLbl3 , studentLbl4 , studentLbl5 ;

        //Declare JTextFields
        JTextField academicYearTxt , semesterTxt ,  programTxt , groupNumberTxt , subGroupNumberTxt;

        //Creating Labels
        studentLbl1 = new JLabel("Academic Year");
        studentLbl1.setFont(studentLbl1.getFont().deriveFont(20f));
        studentLbl1.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        studentLbl2 = new JLabel("Semester");
        studentLbl2.setFont(studentLbl2.getFont().deriveFont(20f));
        studentLbl2.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        studentLbl3 = new JLabel("Program");
        studentLbl3.setFont(studentLbl3.getFont().deriveFont(20f));
        studentLbl3.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        studentLbl4 = new JLabel("Group Number");
        studentLbl4.setFont(studentLbl4.getFont().deriveFont(20f));
        studentLbl4.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        studentLbl5 = new JLabel("Sub Group Number");
        studentLbl5.setFont(studentLbl5.getFont().deriveFont(20f));
        studentLbl5.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        //Creating TextFields
        academicYearTxt=new JTextField("");
        academicYearTxt.setFont(academicYearTxt.getFont().deriveFont(20f));
        academicYearTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        semesterTxt=new JTextField("");
        semesterTxt.setFont(semesterTxt.getFont().deriveFont(20f));
        semesterTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        programTxt=new JTextField("");
        programTxt.setFont(programTxt.getFont().deriveFont(20f));
        programTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        groupNumberTxt=new JTextField("");
        groupNumberTxt.setFont(groupNumberTxt.getFont().deriveFont(20f));
        groupNumberTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        subGroupNumberTxt=new JTextField("");
        subGroupNumberTxt.setFont(subGroupNumberTxt.getFont().deriveFont(20f));
        subGroupNumberTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

    }
}
