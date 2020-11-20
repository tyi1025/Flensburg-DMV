package view;

import database.LicenceHolderDatabase;
import model.LicenceHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

class SearchIdFrame extends SearchFrame {
    public SearchIdFrame()
    {
        setTitle("Search a licence holder by ID");

        label.setText("Input an ID to search");

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
                String idstr = field.getText();
                int idi = Integer.parseInt(idstr);

                LicenceHolder foundHolder = LicenceHolderDatabase.getInstance().searchById(idi);

                if(foundHolder == null) showMessageDialog(panel, "Licence holder not found", "ERROR", ERROR_MESSAGE);

                else{
                    int id = foundHolder.getId();
                    String regNumber = foundHolder.getRegNumber();
                    String firstName = foundHolder.getFirstName();
                    String lastName = foundHolder.getLastName();
                    int penaltyPoints = foundHolder.getPenaltyPoint();
                    new DisplayFrame(id, regNumber, firstName, lastName, penaltyPoints);
                }
            }
        });

    }
}
