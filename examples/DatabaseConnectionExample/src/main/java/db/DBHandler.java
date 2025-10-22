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

/**
 * this class is used to handle the database connection and reading/writing data
 * postgresql is used as database
 * https://www.tutorialspoint.com/postgresql/postgresql_environment.htm
 * @author srh
 *
 */
public class DBHandler {

    public static Connection conn = null;

    /**
     * singleton to get the connection
     * @return the connection to the database
     */
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sdpexample","postgres", "admin");
                conn.setAutoCommit(false);
                System.out.println("Opened database connection successfully");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        }
        return conn;
    }

    /**
     * reads the courses from the database table and creates an array list with objects of type course
     * @return the list of courses
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
            e.printStackTrace();
        }
        return result;
    }

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
            e.printStackTrace();
        }
        System.out.println("New Course created");
    }

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
            e.printStackTrace();
        }
        System.out.println("Course updated");
    }


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
            e.printStackTrace();
        }
        System.out.println("Course deleted");
    }


    /**
     * reads the courses from the database table and creates an array list with objects of type course
     * @return the list of courses
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
            e.printStackTrace();
        }
        return students;
    }


}
