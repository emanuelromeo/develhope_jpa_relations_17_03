package com.crud.jpa_relations_17_03.entity.many_to_many;

import com.crud.jpa_relations_17_03.entity.one_to_one.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<MtMStudent> mtmStudents;

    public Course() {
    }

    public Course(Long id, String name, List<MtMStudent> mtmStudents) {
        this.id = id;
        this.name = name;
        this.mtmStudents = mtmStudents;
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

    public List<MtMStudent> getMtmStudents() {
        return mtmStudents;
    }

    public void setStudents(List<MtMStudent> mtmStudents) {
        this.mtmStudents = mtmStudents;
    }

    public void addStudent(MtMStudent student) {
        this.mtmStudents.add(student);
    }

    public void removeStudent(MtMStudent student) {
        this.mtmStudents.remove(student);
    }
}
