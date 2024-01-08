package com.kelompok7.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "courses")
public class Course {
    @Id
    private long id;
    @Column(name = "name")
    private String name;

    public Course() {
    }

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
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


}
