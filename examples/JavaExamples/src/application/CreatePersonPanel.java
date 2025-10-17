package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.DBHandler;
import application.Person;

/**
 * inherits from JPanel
 * and implemenets an action listener (enables state change on button click)
 * @author srh
 *
 */
public class CreatePersonPanel extends JPanel implements ActionListener {
	
	public static final String SAVE_PERSON_COMMAND = "SAVE_PERSON";
	public static final String RESET_FORM = "RESET_FORM";
	// the fields are important to get the first and last name
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JButton saveButton;
	
	
	public CreatePersonPanel() {
		// create a layout in vertical arrangement
		BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(bl);
		
		// create label and field to first and lastname
		JLabel firstNameLabel = new JLabel("Firstname");
		this.add(firstNameLabel);
		this.firstNameField = new JTextField(20);
		// avoids larget text fields
		this.firstNameField.setMaximumSize( this.firstNameField.getPreferredSize() );
		this.add(this.firstNameField);   
		
		JLabel lastNameLabel = new JLabel("Lastname");
		this.add(lastNameLabel);
		lastNameField = new JTextField(20);
		lastNameField.setMaximumSize( lastNameField.getPreferredSize() );
		this.add(lastNameField);  	
		JPanel buttonPanel = new JPanel();
		BoxLayout buttonLayout =new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(buttonLayout);
		// creates the save button and assigns the event listener for the button click
		// the event listener is implemented in this class
		JButton saveButton = new JButton("Save");
		saveButton.setActionCommand(SAVE_PERSON_COMMAND);
		saveButton.addActionListener(this);
		buttonPanel.add(saveButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setActionCommand(RESET_FORM);
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);
		this.add(buttonPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION IS TRIGGERED: "+e.getActionCommand());
		// saves the person data in case the person command is provided
		if (SAVE_PERSON_COMMAND.equals(e.getActionCommand())) {
			Person newPerson = new Person();
			// get the data from the text fields
			newPerson.setFirstName(firstNameField.getText());
			newPerson.setLastName(lastNameField.getText());
			// save the new person to the database
			DBHandler dbh = new DBHandler();
			dbh.insertPerson(newPerson);
			System.out.println("New Person created");
		}
		if (RESET_FORM.equals(e.getActionCommand())) {
			firstNameField.setText("");
			lastNameField.setText("");
		}
		
	}
	
	
	
}
