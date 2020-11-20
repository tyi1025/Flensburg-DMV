package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout
{
    JFrame frame = new JFrame("Welcome to Flensburg DMV");
    JPanel panel = new JPanel();
    JButton btn1 = new JButton("Add a licence holder");
    JButton btn2 = new JButton("Search a licence holder by ID");
    JButton btn3 = new JButton("Search a licence holder by vehicle registration number");
    JButton btn4 = new JButton("Edit a licence holder");
    JButton btn5 = new JButton("Delete a licence holder");

    public Layout() {

        panel.setLayout(new GridLayout(2, 3, 3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButtonPressed();
            }

            private void addButtonPressed() {
                new AddFrame();
            }

        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByIdButtonPressed();
            }

            private void searchByIdButtonPressed() {
                new SearchIdFrame();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByRegNumberButtonPressed();
            }

            private void searchByRegNumberButtonPressed() {
                new SearchRegFrame();
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonPressed();
            }

            private void editButtonPressed() {
                new EditSearchFrame();
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonPressed();
            }

            private void deleteButtonPressed() {
                new DeleteSearchFrame();
            }
        });
    }


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Layout();
            }
        });
    }


}
