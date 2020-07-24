package interfaces;

import javax.swing.*;
import java.awt.*;

public class Tags {
    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Declare the Jlabels
        JLabel tagLbl;

        //Declare JTextFields
        JTextField tagTxt;

        //Creating Labels
        tagLbl = new JLabel("Tag");
        tagLbl.setFont(tagLbl.getFont().deriveFont(20f));
        tagLbl.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        //Creating TextFields
        tagTxt=new JTextField("");
        tagTxt.setFont(tagTxt.getFont().deriveFont(20f));
        tagTxt.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));


    }
}
