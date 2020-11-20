package view;

import database.LicenceHolderDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


import static javax.swing.JOptionPane.getRootFrame;
import static javax.swing.JOptionPane.showMessageDialog;

public class DeleteFrame extends DisplayFrame
{
    public DeleteFrame(int id, String regNumber, String firstName, String lastName, int penaltyPoints){
        setTitle("Search result");

        button.setText("Delete");

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
                int reply = JOptionPane.showConfirmDialog(getRootFrame(), "Are you sure you want to delete?", "Delete?",  JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                    LicenceHolderDatabase.getInstance().delete(id);
                    dispatchEvent(new WindowEvent(getRootFrame(), WindowEvent.WINDOW_CLOSING));
                    showMessageDialog(panel, "Delete successful");
                }
            }
        });
    }
}
