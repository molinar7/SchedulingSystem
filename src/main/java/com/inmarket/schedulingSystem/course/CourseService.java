package com.inmarket.schedulingSystem.course;


import com.inmarket.schedulingSystem.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
}
