package com.betterteng.Haha.student;

import com.betterteng.Haha.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
        // TODO
        System.out.println(studentId);
        return studentService.getAllCoursesForStudents(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        System.out.println(student);
        studentService.addNewStudent(student);
    }
}
