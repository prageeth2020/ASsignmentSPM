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

        JLabel Close , Name;

        Name = new JLabel("Time Table Creator");
        Name.setFont(Name.getFont().deriveFont(20f));
        Name.setForeground(Color.WHITE);
        Name.setSize(new Dimension(100 , 40));
        Close = new JLabel("X");
        Close.setFont(Close.getFont().deriveFont(20f));
        Close.setForeground(Color.WHITE);

        panel1.add(Name);
        panel1.add(Close);

        f.add(panel1);

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
