package view;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame
{

    JPanel panel = new JPanel(new GridLayout(6, 2, 3, 3));

    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    JTextField field5 = new JTextField();

    JLabel label1 = new JLabel("ID");
    JLabel label2 = new JLabel("Vehicle registration number");
    JLabel label3 = new JLabel("First name");
    JLabel label4 = new JLabel("Last name");
    JLabel label5 = new JLabel("Penalty Points");

    JButton confirm = new JButton("Confirm");

}
