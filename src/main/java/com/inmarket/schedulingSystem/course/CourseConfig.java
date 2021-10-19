package com.inmarket.schedulingSystem.course;


import com.inmarket.schedulingSystem.student.Student;
import com.inmarket.schedulingSystem.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner courseCommandLineRunner(CourseRepository repository){
        return args -> {

            Course javaCourse = new Course(
                    "Java",
                    "Learning Java"
            );

            Course mathCourse = new Course(
                    "Math",
                    "Learning math"
            );

            repository.saveAll(
                    Stream.of(javaCourse, mathCourse)
                            .collect(Collectors.toList()));
        };
    }
}
