package data;

import java.util.UUID;

/**
 * Represents a student entity with personal and course information.
 */
public class Student {
    UUID id;
    String firstName;
    String lastName;
    String city;
    UUID courseId;

    /**
     * Default constructor for Student.
     */
    public Student() {

    }

    /**
     * Constructs a Student with all fields initialized.
     * @param id The unique identifier of the student
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @param city The city where the student lives
     * @param courseId The UUID of the course of studies the student is enrolled in
     */
    public Student(UUID id, String firstName, String lastName, String city, UUID courseId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.courseId = courseId;
    }

    /**
     * Gets the unique identifier of the student.
     * @return UUID of the student
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the student.
     * @param id UUID to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the first name of the student.
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     * @param firstName First name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     * @param lastName Last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the city where the student lives.
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the student lives.
     * @param city City to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the UUID of the course of studies the student is enrolled in.
     * @return UUID of the course of studies
     */
    public UUID getCourseId() {
        return courseId;
    }

    /**
     * Sets the UUID of the course of studies the student is enrolled in.
     * @param courseId UUID to set
     */
    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}
