package com.inmarket.schedulingSystem.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(exist){
            studentRepository.deleteById(studentId);
        } else{
            throw new IllegalStateException("Student with id does not exist");
        }

    }

    @Transactional
    public void updateStudent(Long studentId, String firstName, String lastName) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id does not exist"));

        if(firstName!= null && !firstName.isEmpty()){
            student.setFirstName(firstName);
        }

        if(lastName != null && !lastName.isEmpty()){
            student.setLastName(lastName);
        }
    }
}
