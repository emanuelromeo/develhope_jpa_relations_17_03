package com.crud.jpa_relations_17_03.entity.many_to_many;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mtmstudents")
public class MtMStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "subscriptions",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @Column(name = "deleted")
    private boolean deleted = false;

    public MtMStudent() {
    }

    public MtMStudent(Long id, String name, List<Course> courses, boolean deleted) {
        this.id = id;
        this.name = name;
        this.courses = courses;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
