package view;

import database.LicenceHolderDatabase;
import model.LicenceHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

class SearchRegFrame extends SearchFrame
{
    public SearchRegFrame()
    {

        setTitle("Search a licence holder by vehicle registration number");

        label.setText("Input a vehicle registration number to search");

        panel.add(label);
        panel.add(field);

        panel.add(confirm);
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(600,400);
        setVisible(true);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchConfirmed();
            }
            private void searchConfirmed()
            {
                String regNumber = field.getText();

                LicenceHolder foundHolder = LicenceHolderDatabase.getInstance().searchByRegNumber(regNumber);
                if(foundHolder == null) showMessageDialog(panel, "Licence holder not found", "ERROR", ERROR_MESSAGE);
                else{
                    int id = foundHolder.getId();
                    String firstName = foundHolder.getFirstName();
                    String lastName = foundHolder.getLastName();
                    int penaltyPoints = foundHolder.getPenaltyPoint();
                    new DisplayFrame(id, regNumber, firstName, lastName, penaltyPoints);
                }
            }
        });

    }
}
