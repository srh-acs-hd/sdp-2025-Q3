import data.CourseOfStudies;
import data.Student;
import db.DBHandler;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.UUID;

public class DatabaseTest {
    public static void main(String[] args) {
        System.out.println("Now connecting to database");
        try {
            Connection conn = DBHandler.getConnection();
        } catch (SQLException e) {
            System.out.println("Connection could not be established");
        }
        DBHandler dbc = new DBHandler();
        ArrayList<CourseOfStudies> courses = dbc.readCourses();
        for (CourseOfStudies course : courses) {
            System.out.println(course.getId()+ " "+ course.getName());
        }

        ArrayList<Student> students = dbc.readStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            String studentText = student.getLastName()+" ,"+ student.getFirstName();
            System.out.println(studentText);
        }

        CourseOfStudies biologyCourse = new CourseOfStudies();
        biologyCourse.setId(UUID.randomUUID());
        biologyCourse.setName("Biology");
        biologyCourse.setDescription(("Science about animals and plants"));
        //dbc.writeCourse(biologyCourse);

        dbc.deleteCourse(UUID.fromString("5a23e58a-3db8-4942-838f-bf0f2bc856fa"));

        dbc.deleteCourse(UUID.fromString("d0b88794-b21a-4c04-800c-5bb84f69e1cb"));
    }
}
