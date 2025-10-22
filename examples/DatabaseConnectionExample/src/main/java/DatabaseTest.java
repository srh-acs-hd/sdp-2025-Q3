import data.CourseOfStudies;
import data.Student;
import db.DBHandler;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class demonstrates how to connect to a database, read and display data,
 * and perform basic operations such as deleting and (optionally) inserting records.
 *
 * The example uses the DBHandler class to manage database access for two entities:
 *   - CourseOfStudies: Represents a course or program at a university.
 *   - Student: Represents a student enrolled in a course.
 *
 * Key concepts shown in this example:
 *   - Establishing a database connection using a handler class
 *   - Reading all records from a table and displaying them
 *   - Creating and initializing objects in Java
 *   - Deleting records by their unique identifier (UUID)
 *   - (Commented) Inserting a new record into the database
 *
 * This example is intended for Java learners to understand basic database operations
 * and object-oriented programming concepts in a real-world context.
 */
public class DatabaseTest {
    /**
     * Main method to run the database test example.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Now connecting to database");
        try {
            // Establish a connection to the database using the DBHandler class
            Connection conn = DBHandler.getConnection();
        } catch (SQLException e) {
            System.out.println("Connection could not be established");
        }
        // Create a DBHandler instance to perform database operations
        DBHandler dbc = new DBHandler();

        // Read all courses from the database and print their IDs and names
        ArrayList<CourseOfStudies> courses = dbc.readCourses();
        for (CourseOfStudies course : courses) {
            System.out.println(course.getId()+ " "+ course.getName());
        }

        // Read all students from the database and print their names
        ArrayList<Student> students = dbc.readStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            String studentText = student.getLastName()+", "+ student.getFirstName();
            System.out.println(studentText);
        }

        // Example: Create a new course object (not written to the database in this example)
        CourseOfStudies biologyCourse = new CourseOfStudies();
        biologyCourse.setId(UUID.randomUUID());
        biologyCourse.setName("Biology");
        biologyCourse.setDescription(("Science about animals and plants"));
        // Uncomment the next line to write the new course to the database
        //dbc.writeCourse(biologyCourse);

        // Example: Delete courses by their UUID (replace with actual UUIDs from your database)
        dbc.deleteCourse(UUID.fromString("5a23e58a-3db8-4942-838f-bf0f2bc856fa"));
        dbc.deleteCourse(UUID.fromString("d0b88794-b21a-4c04-800c-5bb84f69e1cb"));
    }
}
