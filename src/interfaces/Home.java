package interfaces;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
        panel3.setBounds((int) (screenSize.width*0.05),(int) (screenSize.height*0.04),(int) (screenSize.width*0.25),screenSize.height);
        panel3.setBackground(Color.white);

        JPanel panel3right =new JPanel();
        panel3right.setBounds((int) (screenSize.width*0.30),(int) (screenSize.height*0.04),(int) (screenSize.width*0.70),screenSize.height);
        panel3right.setBackground(Color.white);

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
        JLabel LectureLbl1 , LectureLbl2 , LectureLbl3 , LectureLbl4 , LectureLbl5 , LectureLbl6 , LectureLbl7 , LectureLbl8;


        //Declare JTextFields
        JTextField Lecturetxt1 , Lecturetxt2 ,  Lecturetxt3 , Lecturetxt4 , Lecturetxt5 , Lecturetxt6 , Lecturetxt7 , Lecturetxt8;

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


        //Declare Labels
        LectureLbl1 = new JLabel("Name");
        LectureLbl1.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl1.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl2 = new JLabel("Employee ID");
        LectureLbl2.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl2.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl3 = new JLabel("Faculty");
        LectureLbl3.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl3.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl4 = new JLabel("Department");
        LectureLbl4.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl4.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl5 = new JLabel("Center");
        LectureLbl5.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl5.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl6 = new JLabel("Building");
        LectureLbl6.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl6.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl7 = new JLabel("Level");
        LectureLbl7.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl7.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));
        LectureLbl8 = new JLabel("Rank");
        LectureLbl8.setFont(LectureLbl1.getFont().deriveFont(20f));
        LectureLbl8.setPreferredSize(new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));




        //Declare TextFields
        Lecturetxt1=new JTextField("");
        Lecturetxt1.setFont(Lecturetxt1.getFont().deriveFont(20f));
        Lecturetxt1.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt2=new JTextField("");
        Lecturetxt2.setFont(Lecturetxt2.getFont().deriveFont(20f));
        Lecturetxt2.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));


        Lecturetxt3=new JTextField("");
        Lecturetxt3.setFont(Lecturetxt3.getFont().deriveFont(20f));
        Lecturetxt3.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt4=new JTextField("");
        Lecturetxt4.setFont(Lecturetxt4.getFont().deriveFont(20f));
        Lecturetxt4.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt5=new JTextField("");
        Lecturetxt5.setFont(Lecturetxt5.getFont().deriveFont(20f));
        Lecturetxt5.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt6=new JTextField("");
        Lecturetxt6.setFont(Lecturetxt6.getFont().deriveFont(20f));
        Lecturetxt6.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt7=new JTextField("");
        Lecturetxt7.setFont(Lecturetxt7.getFont().deriveFont(20f));
        Lecturetxt7.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        Lecturetxt8=new JTextField("");
        Lecturetxt8.setFont(Lecturetxt7.getFont().deriveFont(20f));
        Lecturetxt8.setPreferredSize( new Dimension( (int) (screenSize.width * 0.22), (int) (screenSize.height*0.04)));

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);


        model.addColumn("RecordID");
        model.addColumn("Name");
        model.addColumn("Employee ID");
        model.addColumn("Faculty");
        model.addColumn("Department");
        model.addColumn("Center");
        model.addColumn("Building");
        model.addColumn("Level");
        model.addColumn("Rank");
        TableColumn a1 = table.getColumnModel().getColumn(0);
        a1.setPreferredWidth((int) (screenSize.width*0.04));
        TableColumn a2 = table.getColumnModel().getColumn(1);
        a2.setPreferredWidth((int) (screenSize.width*0.15));
        TableColumn a3 = table.getColumnModel().getColumn(2);
        a3.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a4 = table.getColumnModel().getColumn(3);
        a4.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a5 = table.getColumnModel().getColumn(4);
        a5.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a6 = table.getColumnModel().getColumn(5);
        a6.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a7 = table.getColumnModel().getColumn(6);
        a4.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a8 = table.getColumnModel().getColumn(7);
        a5.setPreferredWidth((int) (screenSize.width*0.08));
        TableColumn a9 = table.getColumnModel().getColumn(8);
        a6.setPreferredWidth((int) (screenSize.width*0.08));




        //Adding thins to panel1(top Bar)
        panel1.add(Name);
        panel1.add(Close);

        //Adding thins to panel2(Nav Bar)
        panel2.add(icon1);
        panel2.add(icon2);
        panel2.add(icon3);
        panel2.add(icon4);


        panel3.add(LectureLbl1);
        panel3.add(Lecturetxt1);

        panel3.add(LectureLbl2);
        panel3.add(Lecturetxt2);

        panel3.add(LectureLbl3);
        panel3.add(Lecturetxt3);

        panel3.add(LectureLbl4);
        panel3.add(Lecturetxt4);

        panel3.add(LectureLbl5);
        panel3.add(Lecturetxt5);

        panel3.add(LectureLbl6);
        panel3.add(Lecturetxt6);

        panel3.add(LectureLbl7);
        panel3.add(Lecturetxt7);

        panel3.add(LectureLbl8);
        panel3.add(Lecturetxt8);

        panel3right.add(table.getTableHeader());
        panel3right.add(table);


        //Add all Panels to the Forms
        f.add(panel1);
        f.add(panel2);
        f.add(panel3);
        f.add(panel3right);
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
