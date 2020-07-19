package interfaces;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

    public static void main(String[] args) {

        //Create form
        JFrame f= new JFrame("Temple Run");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setBackground(Color.white);

        //Creating Panels
        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,screenSize.width,(int) (screenSize.height*0.04));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.setBackground(Color.pink);

        JPanel panel2=new JPanel();
        panel2.setBounds(0,(int) (screenSize.height*0.04),(int) (screenSize.width * 0.05),screenSize.height);
        panel2.setBackground(Color.lightGray);

        JPanel panel3 =new JPanel();
        panel3.setBounds((int) (screenSize.width*0.05),(int) (screenSize.height*0.04),(int) (screenSize.width*0.95),screenSize.height);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setBackground(Color.white);

        JPanel panel4 =new JPanel();
        panel4.setBounds((int) (screenSize.width*0.05),(int) (screenSize.height*0.04),(int) (screenSize.width*0.95),screenSize.height);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.setBackground(Color.white);

        JPanel panel5 =new JPanel();
        panel5.setBounds((int) (screenSize.width*0.05),(int) (screenSize.height*0.04),(int) (screenSize.width*0.95),screenSize.height);
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        panel5.setBackground(Color.white);

        JPanel panel6 =new JPanel();
        panel6.setBounds((int) (screenSize.width*0.05),(int) (screenSize.height*0.04),(int) (screenSize.width*0.95),screenSize.height);
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
        panel6.setBackground(Color.white);

        //set Visibility of panels
        panel3.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);

        //Declare the Jlabels
        JLabel Close , Name , icon1 , icon2 , icon3 , icon4;

        //Label for Topic
        Name = new JLabel("<html><span style='font-size:20px'><font color='white' > Time Table Creation</font></span></html>");
        Name.setForeground(Color.WHITE);
        Name.setPreferredSize(new Dimension( (int) (screenSize.width * 0.95), (int) (screenSize.height*0.04)));

        //Label for Close Button
        Close = new JLabel("<html><span style='font-size:20px'><font align='center' > X </font></span></html>" , SwingConstants.CENTER);
        Close.setFont(Close.getFont().deriveFont(20f));
        Close.setOpaque(true);
        Close.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red) );
        Close.setBackground(Color.red);
        Close.setForeground(Color.WHITE);


        //Define LAbels for nav bar
        icon1 = new JLabel(new ImageIcon("./src/interfaces/JlabelIcon1.png"));
        icon1.setBackground(Color.white);
        icon1.setOpaque(true);

        icon2 = new JLabel(new ImageIcon("./src/interfaces/JlabelIcon1.png"));
        icon2.setBackground(Color.lightGray);
        icon2.setOpaque(true);

        icon3 = new JLabel(new ImageIcon("./src/interfaces/JlabelIcon1.png"));
        icon3.setBackground(Color.lightGray);
        icon3.setOpaque(true);

        icon4 = new JLabel(new ImageIcon("./src/interfaces/JlabelIcon1.png"));
        icon4.setBackground(Color.lightGray);
        icon4.setOpaque(true);




        //Adding thins to panel1(top Bar)
        panel1.add(Name);
        panel1.add(Close);

        //Adding thins to panel2(Nav Bar)
        panel2.add(icon1);
        panel2.add(icon2);
        panel2.add(icon3);
        panel2.add(icon4);



        //Add all Panels to the Forms
        f.add(panel1);
        f.add(panel2);
        f.add(panel3);
        f.add(panel4);
        f.add(panel5);
        f.add(panel6);


        //Form Properties
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        f.setResizable(false);
        f.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.PINK));
        f.setLayout(null);
        f.setVisible(true);

        Close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        icon1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                icon1.setBackground(Color.white);
                icon2.setBackground(Color.lightGray);
                icon3.setBackground(Color.lightGray);
                icon4.setBackground(Color.lightGray);


                panel3.setVisible(true);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel6.setVisible(false);
            }
        });

        icon2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panel3.setVisible(false);
                panel4.setVisible(true);
                panel5.setVisible(false);
                panel6.setVisible(false);

                icon1.setBackground(Color.lightGray);
                icon2.setBackground(Color.white);
                icon3.setBackground(Color.lightGray);
                icon4.setBackground(Color.lightGray);

            }
        });

        icon3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(true);
                panel6.setVisible(false);

                icon1.setBackground(Color.lightGray);
                icon2.setBackground(Color.lightGray);
                icon3.setBackground(Color.white);
                icon4.setBackground(Color.lightGray);

            }
        });


        icon4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel6.setVisible(true);

                icon1.setBackground(Color.lightGray);
                icon2.setBackground(Color.lightGray);
                icon3.setBackground(Color.lightGray);
                icon4.setBackground(Color.white);

            }
        });



    }
}
