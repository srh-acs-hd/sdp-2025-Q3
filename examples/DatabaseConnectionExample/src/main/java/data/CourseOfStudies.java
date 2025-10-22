package data;

import java.util.UUID;

/**
 * Represents a course of studies entity with an ID, name, and description.
 */
public class CourseOfStudies {
    UUID id;
    String name;
    String description;

    /**
     * Default constructor for CourseOfStudies.
     */
    public CourseOfStudies() {
        this.id = UUID.randomUUID();
    }

    /**
     * Constructs a CourseOfStudies with all fields initialized.
     *
     * @param id          The unique identifier of the course
     * @param name        The name of the course
     * @param description The description of the course
     */
    public CourseOfStudies(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the unique identifier of the course.
     *
     * @return UUID of the course
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the course.
     *
     * @param id UUID to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the name of the course.
     *
     * @return Name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the course.
     *
     * @return Description of the course
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     *
     * @param description Description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
