package view;

import database.LicenceHolderDatabase;
import model.LicenceHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

class EditSearchFrame extends SearchFrame {


    public EditSearchFrame() {
        setTitle("Edit a licence holder");

        JTextField field1 = new JTextField();


        JLabel label1 = new JLabel("Input your key to search. A valid key can be the ID or vehicle registration number.");


        JButton confirm = new JButton("Confirm");

        panel.add(label1);
        panel.add(field1);

        panel.add(confirm);


        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(600,400);
        setVisible(true);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editConfirmed();
            }
            private void editConfirmed()
            {
                LicenceHolder foundHolder;
                String keystr = field1.getText();
                if(isInteger(keystr)) {
                    int idi = Integer.parseInt(keystr);
                    foundHolder = LicenceHolderDatabase.getInstance().searchById(idi);

                    if(foundHolder == null) showMessageDialog(panel, "Licence holder not found", "ERROR", ERROR_MESSAGE);
                    assert foundHolder != null;

                } else {
                    foundHolder = LicenceHolderDatabase.getInstance().searchByRegNumber(keystr);

                    if(foundHolder == null) showMessageDialog(panel, "Licence holder not found", "ERROR", ERROR_MESSAGE);
                    assert foundHolder != null;
                }

                int id = foundHolder.getId();
                String regNumber = foundHolder.getRegNumber();
                String firstName = foundHolder.getFirstName();
                String lastName = foundHolder.getLastName();
                int penaltyPoints = foundHolder.getPenaltyPoint();

                new EditFrame(id, regNumber, firstName, lastName, penaltyPoints);
            }

            private boolean isInteger(String key)
            {
                try
                {
                    Integer.parseInt(key);
                    return true;
                }
                catch(NumberFormatException e){
                    return false;
                }
            }
        });

    }
}
