package ui;

import data.CourseOfStudies;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CoursePanel extends JPanel {
    ArrayList<CourseOfStudies> courses;

    public CoursePanel() {
        super();
        courses = new ArrayList<CourseOfStudies>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    public void displayCourses(ArrayList<CourseOfStudies>  courses) {
        this.courses = courses;
        System.out.println("updating the UI");
        for (CourseOfStudies course : courses) {
            System.out.println("Course: " + course.getName() + " - " + course.getDescription());
            Label l = new Label(course.getName());
            Label descriptionLabel = new Label(course.getDescription());
            l.setFont(new Font("Arial", Font.BOLD, 16));
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            this.add(l);
            this.add(descriptionLabel);
        }
    }
}
