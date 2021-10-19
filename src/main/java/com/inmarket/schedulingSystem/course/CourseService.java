package com.inmarket.schedulingSystem.course;


import com.inmarket.schedulingSystem.student.Student;
import com.inmarket.schedulingSystem.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        boolean exist = courseRepository.existsById(courseId);
        if(exist){
            courseRepository.deleteById(courseId);
        } else{
            throw new IllegalStateException("Course with id does not exist");
        }

    }

    @Transactional
    public void updateCourse(Long courseId, String description) {
        {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new IllegalStateException("Course with id does not exist"));

            if(description!= null && !description.isEmpty()){
                course.setDescription(description);
            }
        }
    }

    public void addStudentToCourse(Long courseId, Long studentId) { //
        Course course = courseRepository.getById(courseId); // here we can add logic to check if the course uis already enrolled.
        Student student = studentRepository.getById(studentId);
        course.enrollStudent(student);
        courseRepository.save(course);

    }

    public Course getCourseById(Long courseId) {
        Optional<Course> courseOpt = Optional.of(courseRepository.findById(courseId).get());

        if (courseOpt.isPresent()) {
            return courseOpt.get();
        } else {
            throw new IllegalStateException("Course with id does not exist");
        }
    }
}
