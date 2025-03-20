package com.crud.jpa_relations_17_03.controller.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.Course;
import com.crud.jpa_relations_17_03.entity.one_to_one.Address;
import com.crud.jpa_relations_17_03.service.many_to_many.CourseService;
import com.crud.jpa_relations_17_03.service.one_to_one.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {

        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);

    }

    @GetMapping("/select-by-id/{id}")
    public ResponseEntity<Course> selectCourseById(@PathVariable Long id) {

        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/select-all")
    public ResponseEntity<List<Course>> selectAllCourses() {

        List<Course> courses = courseService.findAllCourses();
        return ResponseEntity.ok(courses);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {

        Optional<Course> optionalCourse = courseService.updateCourse(id, course);

        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteCourseById(@RequestBody Long id) {

        courseService.deleteCourseById(id);
        return ResponseEntity.ok("Deleted");

    }
}
