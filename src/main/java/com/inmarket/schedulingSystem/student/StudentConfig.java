package com.inmarket.schedulingSystem.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner studentCommandLineRunner(StudentRepository repository){
        return args -> {

            Student mario = new Student(
                    "Molinar",
                    "Mario"
            );

            Student maria = new Student(
                    "Lopez",
                    "Fernando"
            );

            repository.saveAll(
                    Stream.of(maria, mario)
                            .collect(Collectors.toList()));
        };
    }
}
