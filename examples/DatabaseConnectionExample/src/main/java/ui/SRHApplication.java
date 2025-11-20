package ui;
import db.DBHandler;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SRHApplication extends JFrame implements ChangeListener {

    // this is our main panel
    private JPanel contentPanel;
    // here we have tabs for displaying data and creating data
    private JTabbedPane tabbedPane;
    // own class to display persons
    private StudentsPanel studentsPanel;
    private CoursePanel coursePanel;
    public SRHApplication() {
        // call the constructor of superclass (JFrame) with a title
        super("SRH Application Example 2025");
        // set the window size
        this.setSize(700, 500);
        // create the UI
        this.createContentPanel();
        // set the tabbed pane and show the window
        this.setContentPane(tabbedPane);
        this.setVisible(true);
    }

    public void createContentPanel() {
        tabbedPane = new JTabbedPane();
        coursePanel = new CoursePanel();
        studentsPanel = new StudentsPanel();

        // create two tabs with the list and the create from
        tabbedPane.add("Courses", coursePanel);
        tabbedPane.add("Students", studentsPanel);
        // add an event listener (this class) to react on choosing a tab
        tabbedPane.addChangeListener(this);
        // load and display the person list
        this.loadAndDisplayData();
    }

    public void loadAndDisplayData() {
        // loads the data from the database
        DBHandler dbh = new DBHandler();
        //ArrayList<Person> personsFromDB = dbh.readPersons();
        // displays the person on the panel
        //personListPanel.showPersons(personsFromDB);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // reacts on the state change of the tabbedPane


    }

    public static void main(String[] args) {
        try {
            System.setProperty("sun.java2d.uiScale", "2.5");
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // create our own application based on a jframe
            new SRHApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
