package com.inmarket.schedulingSystem.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inmarket.schedulingSystem.student.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "course_sequence"
    )
    private long id;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Student> enrolledStudents = new HashSet<>();

    private String title;

    private String description;

    public Course() {

    }

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void enrollStudent(Student student){
        this.enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", enrolledStudents=" + enrolledStudents +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
