package kz.aitu.advancedJava.controller;

import kz.aitu.advancedJava.model.Student;
import kz.aitu.advancedJava.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/students/group/{groupId}")
    public ResponseEntity<?> getStudents(@PathVariable Long groupId) {
        return ResponseEntity.ok(studentRepository.findAllByGroupId(groupId));
    }

    @GetMapping("/api/students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/api/students/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentRepository.findById(studentId));
    }
}
