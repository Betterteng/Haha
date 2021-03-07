package com.betterteng.Haha.student;

import com.betterteng.Haha.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;

    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    @Autowired
    List<Student> getAllStudents () {

        return studentDataAccessService.selectAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null, student);
    }

    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId) // If Id is null, then generate one.
                .orElse(UUID.randomUUID());

        if (studentDataAccessService.isEmailTake(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " has been take..." +
                    "\n So we cannot save it to the database...");
        }

        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
