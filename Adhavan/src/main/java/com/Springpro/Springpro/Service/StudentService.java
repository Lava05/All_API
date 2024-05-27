package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;



    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public void updateStudent(Long id, Student student) {
//        student.setId(id);
        studentRepo.getById(id);
        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


}
