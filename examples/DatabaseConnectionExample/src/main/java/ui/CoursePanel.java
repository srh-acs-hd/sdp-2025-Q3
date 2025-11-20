package ui;

import data.CourseOfStudies;

import javax.swing.*;
import java.util.ArrayList;

public class CoursePanel extends JPanel {
    ArrayList<CourseOfStudies> courses;

    public CoursePanel() {
        super();
        courses = new ArrayList<CourseOfStudies>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setCourses(ArrayList<CourseOfStudies> courses) {
        this.courses = courses;
    }

    public void displayCourses() {
        System.out.println("updating the UI");
        for (CourseOfStudies course : courses) {
            System.out.println("Course: " + course.getName() + " - " + course.getDescription());
        }
    }
}
