package com.inmarket.schedulingSystem.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inmarket.schedulingSystem.course.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence"
    )
    private long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses = new HashSet<>();

    private String lastName;

    private String firstName;


    public Student() {
    }

    public Student(long id, String lasName, String firstName) {
        this.id = id;
        this.lastName = lasName;
        this.firstName = firstName;
    }

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", curses=" + courses +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
