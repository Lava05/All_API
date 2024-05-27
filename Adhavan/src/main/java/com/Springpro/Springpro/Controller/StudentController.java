package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
       studentService.addStudent(student);
        return "Added Student details";
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
//        System.out.println(id);
        System.out.println(studentService.getStudentById(id));
        return studentService.getStudentById(id);
    }

    @PutMapping("/put")
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student) {
       studentService.updateStudent(id, student);
        return student;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        System.out.println(id);
        studentService.deleteStudent(id);
        return "Deleted";
    }
}



