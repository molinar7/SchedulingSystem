package com.inmarket.schedulingSystem.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path= "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteCourse(courseId);
    }

    @PutMapping(path = "{courseId}")
    public void updateStudent(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = true) String description) {

        courseService.updateCourse(courseId, description);

    }

    @PutMapping("/{courseId}/students/{studentId}")
    private void enrollStudentToCourse(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        courseService.addStudentToCourse(courseId, studentId);
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

}
