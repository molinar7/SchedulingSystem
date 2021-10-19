package com.inmarket.schedulingSystem.course;

import com.inmarket.schedulingSystem.student.Student;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;

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


    public Set<Student> getLikes() {
        return likes;
    }

    public void setLikes(Set<Student> likes) {
        this.likes = likes;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", likes=" + likes +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
