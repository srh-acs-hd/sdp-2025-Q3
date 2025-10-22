package db;
import data.CourseOfStudies;
import data.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * this class is used to handle the database connection and reading/writing data
 * postgresql is used as database
 * <a href="https://www.tutorialspoint.com/postgresql/postgresql_environment.htm">...</a>
 * @author srh
 *
 */
public class DBHandler {

    public static Connection conn = null;
    private static final Logger LOGGER = Logger.getLogger(DBHandler.class.getName());

    /**
     * Establishes a singleton connection to the database.
     * Initializes the connection if it does not exist or is closed.
     * Returns the Connection instance.
     * @return Connection to the PostgreSQL database
     * @throws SQLException if an error occurs while connecting
     */
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sdpexample","postgres", "admin");
                conn.setAutoCommit(false);
                System.out.println("Opened database connection successfully");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to open database connection", e);
                LOGGER.severe(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        }
        return conn;
    }

    /**
     * Reads all courses from the "courseofstudies" table and returns them as a list.
     * @return ArrayList of CourseOfStudies objects
     */
    public ArrayList<CourseOfStudies> readCourses() {
        ArrayList<CourseOfStudies> result = new ArrayList<CourseOfStudies>();
        try {
            Statement stmt = DBHandler.getConnection().createStatement();
            String sql = "SELECT * FROM \"courseofstudies\"";
            ResultSet rs = stmt.executeQuery(sql);
            int counter = 0;
            while ( rs.next() ) {
                String idString = rs.getString("id");
                UUID id = UUID.fromString((idString));
                String name = rs.getString("name");
                String description  = rs.getString("description");
                CourseOfStudies p = new CourseOfStudies(id, name, description);
                result.add(p);
                counter++;
                System.out.println("Row: "+counter+" "+p.getName());
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("An Error occured during read Persons");
            LOGGER.log(Level.SEVERE, "Error reading courses from database", e);
        }
        return result;
    }

    /**
     * Writes a new course to the "courseofstudies" table.
     * @param course The CourseOfStudies object to be saved
     */
    public void writeCourse(CourseOfStudies course){

        try {
            Statement stmt = DBHandler.getConnection().createStatement();

            String sql = "INSERT INTO \"courseofstudies\" (id, name, description) "
                    + "VALUES ('" + course.getId() + "', '" + course.getName() + "', '" + course.getDescription() + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Creation of course failed");
            LOGGER.log(Level.SEVERE, "Error creating course", e);
        }
        System.out.println("New Course created");
    }

    /**
     * Updates an existing course in the "courseofstudies" table.
     * @param course The CourseOfStudies object to be updated
     */
    public void updateCourse(CourseOfStudies course){
        try {
            Statement stmt = DBHandler.getConnection().createStatement();
            String sql = "UPDATE \"courseofstudies\" "
                    + "SET name = '"+course.getName()+"', description = '"+course.getDescription()+"' "
                    + "WHERE id ='"+course.getId().toString()+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Update of course failed");
            LOGGER.log(Level.SEVERE, "Error updating course", e);
        }
        System.out.println("Course updated");
    }


    /**
     * Deletes a course by ID from the "courseofstudies" table.
     * @param id The UUID of the course to be deleted
     */
    public void deleteCourse(UUID id) {
        try {
            Statement stmt = DBHandler.getConnection().createStatement();

            String sql = "DELETE FROM \"courseofstudies\" "
                    + "WHERE id ='"+id.toString()+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Creation of course failed");
            LOGGER.log(Level.SEVERE, "Error deleting course", e);
        }
        System.out.println("Course deleted");
    }


    /**
     * Reads all students from the "student" table and returns them as a list.
     * @return ArrayList of Student objects
     */
    public ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Statement stmt = DBHandler.getConnection().createStatement();
            String sql = "SELECT * FROM \"student\"";
            ResultSet rs = stmt.executeQuery(sql);
            int counter = 0;
            while ( rs.next() ) {
                Student student = new Student();
                String idString = rs.getString("id");
                student.setId(UUID.fromString((idString)));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setCity(rs.getString("city"));
                student.setCourseId(UUID.fromString(rs.getString("courseofstudies_id")));
                students.add(student);
                counter++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("An Error occured during read Students");
            LOGGER.log(Level.SEVERE, "Error reading students from database", e);
        }
        return students;
    }

    /**
     * Writes a new student to the "student" table.
     * @param student The Student object to be saved
     */
    public void writeStudent(Student student) {

        try {
            Statement stmt = DBHandler.getConnection().createStatement();

            String sql = "INSERT INTO \"student\" (id, firstName, lastName, city, courseofstudies_id) "
                    + "VALUES ('" + student.getId() + "', '" + student.getFirstName() + "', '" + student.getLastName() + "', '"
                    + student.getCity() + "', '" + student.getCourseId() + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Creation of student failed");
            LOGGER.log(Level.SEVERE, "Error creating student", e);
        }
        System.out.println("New Student created");
    }


    /**
     * Updates an existing student in the "student" table.
     * @param student The Student object to be updated
     */
    public void updateStudent(Student student) {
        try {
            Statement stmt = DBHandler.getConnection().createStatement();
            String sql = "UPDATE \"student\" "
                    + "SET firstName = '"+student.getFirstName()+"', lastName = '"+student.getLastName()+"', city = '"+student.getCity()+"', "
                    + "courseofstudies_id = '"+student.getCourseId()+"' "
                    + "WHERE id ='"+student.getId().toString()+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Update of student failed");
            LOGGER.log(Level.SEVERE, "Error updating student", e);
        }
        System.out.println("Student updated");
    }

    /**
     * Deletes a student by ID from the "student" table.
     * @param id The UUID of the student to be deleted
     */
    public void deleteStudent(UUID id) {
        try {
            Statement stmt = DBHandler.getConnection().createStatement();

            String sql = "DELETE FROM \"student\" "
                    + "WHERE id ='"+id.toString()+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            DBHandler.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("Deletion of student failed");
            LOGGER.log(Level.SEVERE, "Error deleting student", e);
        }
        System.out.println("Student deleted");
    }



}
