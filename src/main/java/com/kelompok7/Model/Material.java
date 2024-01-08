package com.kelompok7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "course")
    private String course;

    public Material() {
    }

    public Material(long id, String name, String description, String course) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
