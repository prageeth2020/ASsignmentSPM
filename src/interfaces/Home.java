package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

    public static void main(String[] args) {

        JFrame f= new JFrame("Temple Run");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(1200,800);
        f.setLocation(400,100);
        f.setBackground(Color.white);

        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,screenSize.width,40);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.setBackground(Color.pink);

        JPanel panel2=new JPanel();
        int width1 = (int) (screenSize.width * 0.05);
        panel2.setBounds(0,40,width1,screenSize.height);
        panel2.setBackground(Color.white);

        JLabel Close , Name , icon1 , icon2 , icon3 , icon4;

        Name = new JLabel("<html><span style='font-size:20px'><font color='white' > Time Table Creation</font></span></html>");

        Name.setForeground(Color.WHITE);
        Name.setPreferredSize(new Dimension( (int) (screenSize.width * 0.95), 40));

        Close = new JLabel("<html><span style='font-size:20px'><font align='center' > X </font></span></html>");
        Close.setFont(Close.getFont().deriveFont(20f));
        Close.setOpaque(true);
        Close.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
        Close.setBackground(Color.red);
        Close.setForeground(Color.WHITE);

        icon1 = new JLabel(new ImageIcon("./src/interfaces/JlabelIcon1.png"));
        icon1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        //icon1.setOpaque(true);
        icon2 = new JLabel("");
        icon3 = new JLabel("");
        icon4 = new JLabel("");
        //icon1.setSize(new Dimension(95 , 40));


        panel1.add(Name);
        panel1.add(Close);

        panel2.add(icon1);
        panel2.add(icon2);
        f.add(panel1);
        f.add(panel2);

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

    }
}
