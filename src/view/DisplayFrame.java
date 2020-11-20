package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayFrame extends JFrame
{
    JPanel panel = new JPanel(new GridLayout(6, 2, 3, 3));

    JLabel label1 = new JLabel("ID");
    JLabel label2 = new JLabel("Vehicle registration number");
    JLabel label3 = new JLabel("First name");
    JLabel label4 = new JLabel("Last name");
    JLabel label5 = new JLabel("Penalty Points");

    JLabel label6 = new JLabel();
    JLabel label7 = new JLabel();
    JLabel label8 = new JLabel();
    JLabel label9 = new JLabel();
    JLabel label10 = new JLabel();

    JButton button = new JButton();

    public DisplayFrame(){}
    public DisplayFrame(int id, String regNumber, String firstName, String lastName, int penaltyPoints)
    {
        setTitle("Search result");

        button.setText("Back");
        panel.add(label1);
        panel.add(label6);
        panel.add(label2);
        panel.add(label7);
        panel.add(label3);
        panel.add(label8);
        panel.add(label4);
        panel.add(label9);
        panel.add(label5);
        panel.add(label10);
        panel.add(button);

        label6.setText(Integer.toString(id));
        label7.setText(regNumber);
        label8.setText(firstName);
        label9.setText(lastName);
        label10.setText(Integer.toString(penaltyPoints));

        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(600,400);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayFrame.super.dispose();
            }
        });
    }
}
