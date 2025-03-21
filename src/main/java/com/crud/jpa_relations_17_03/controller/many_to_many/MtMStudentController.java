package com.crud.jpa_relations_17_03.controller.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.Course;
import com.crud.jpa_relations_17_03.entity.many_to_many.MtMStudent;
import com.crud.jpa_relations_17_03.service.many_to_many.MtMStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mtmstudents")
public class MtMStudentController {

    @Autowired
    private MtMStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<MtMStudent> createStudent(@RequestBody MtMStudent student) {

        MtMStudent savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);

    }

    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<MtMStudent> selectStudentById(@PathVariable Long id) {

        Optional<MtMStudent> optionalStudent = studentService.findStudentById(id);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/select-by-course-id/{course_id}")
    public ResponseEntity<Page<MtMStudent>> selectStudentsByCourseId(
            @PathVariable Long course_id,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {

        Page<MtMStudent> studentPage = studentService.findStudentByCourseId(course_id, pageNumber, pageSize);
        return ResponseEntity.ok(studentPage);

    }

    @GetMapping("/select-all")
    public ResponseEntity<List<MtMStudent>> selectAllStudents() {

        List<MtMStudent> studentList = studentService.findAllStudents();
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MtMStudent> updateStudent(@PathVariable Long id, @RequestBody MtMStudent student) {

        Optional<MtMStudent> optionalStudent = studentService.updateStudent(id, student);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<MtMStudent> deleteAddressById(@PathVariable Long id) {

        Optional<MtMStudent> optionalStudent = studentService.deleteStudentById(id);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/subscribe-to-course/{studentId}/{courseId}")
    public ResponseEntity<MtMStudent> subscribeStudentToExistingCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Optional<MtMStudent> optionalStudent = studentService.addCourseToStudent(studentId, courseId);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/remove-course/{studentId}/{courseId}")
    public ResponseEntity<MtMStudent> removeCourseFromStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Optional<MtMStudent> optionalStudent = studentService.removeCourseFromStudent(studentId, courseId);

        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        }

        return ResponseEntity.notFound().build();
    }
}
