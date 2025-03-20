package com.crud.jpa_relations_17_03.controller.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Student;
import com.crud.jpa_relations_17_03.service.one_to_one.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);

    }

    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Student> selectStudentById(@PathVariable Long id) {

        Optional<Student> optionalStudent = studentService.findStudentById(id);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/select-all")
    public ResponseEntity<List<Student>> selectAllStudents() {

        List<Student> studentList = studentService.findAllStudents();
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {

        Optional<Student> optionalStudent = studentService.updateStudent(id, student);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Student> deleteAddressById(@PathVariable Long id) {

        Optional<Student> optionalStudent = studentService.deleteStudentById(id);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }
}
