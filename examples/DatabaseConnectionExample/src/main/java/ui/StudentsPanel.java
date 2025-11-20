package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel implements ActionListener {
    public StudentsPanel() {
        super();
        JLabel label = new JLabel("Students Panel - To be implemented");
        this.add(label);
        JButton createStundentButton = new JButton("Create Student");
        this.add(createStundentButton);
        createStundentButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Create Student button clicked - To be implemented");

    }
}
