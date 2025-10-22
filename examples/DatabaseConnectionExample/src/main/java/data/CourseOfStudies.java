package data;

import java.util.UUID;

/**
 * class for data management of course of studies
 */
public class CourseOfStudies {
    private UUID id;
    private String name;
    private String description;

    public CourseOfStudies() {
        this.id = UUID.randomUUID();
    }
    public CourseOfStudies(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
