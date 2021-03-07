package com.betterteng.Haha.student;

import com.betterteng.Haha.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {

        //throw new ApiRequestException("Cannot get students with custom exception...");
        //throw new IllegalStateException("oops cannot get students...");
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        System.out.println(student);
        studentService.addNewStudent(student);
    }
}
