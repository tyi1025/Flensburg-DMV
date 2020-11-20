package view;

import database.LicenceHolderDatabase;
import model.LicenceHolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.*;

public class EditFrame extends InfoFrame
{
    public EditFrame(int id,String regNumber,String firstName,String lastName,int penaltyPoints)
    {
        setTitle("Edit a licence holder");

        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(label3);
        panel.add(field3);
        panel.add(label4);
        panel.add(field4);
        panel.add(label5);
        panel.add(field5);
        panel.add(confirm);

        field1.setText(Integer.toString(id));
        field2.setText(regNumber);
        field3.setText(firstName);
        field4.setText(lastName);
        field5.setText(Integer.toString(penaltyPoints));

        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(600,400);
        setVisible(true);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addConfirmed();
            }
            private void addConfirmed()
            {
                String idstr = field1.getText();
                int id = Integer.parseInt(idstr);
                String regNumber = field2.getText();
                String firstName = field3.getText();
                String lastName = field4.getText();
                String pointsstr = field5.getText();
                int penaltyPoints = Integer.parseInt(pointsstr);


                if(!LicenceHolderDatabase.getInstance().edit(id, id, regNumber, firstName, lastName, penaltyPoints))
                showMessageDialog(panel, "Edit unsuccessful, illegal argument", "ERROR", ERROR_MESSAGE);

                dispatchEvent(new WindowEvent(getRootFrame(), WindowEvent.WINDOW_CLOSING));
                showMessageDialog(panel, "Edit successful");
            }
        });
    }
}
