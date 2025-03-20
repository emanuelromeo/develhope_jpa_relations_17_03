package com.crud.jpa_relations_17_03.service.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.Course;
import com.crud.jpa_relations_17_03.entity.many_to_many.MtMStudent;
import com.crud.jpa_relations_17_03.repository.many_to_many.CourseRepository;
import com.crud.jpa_relations_17_03.repository.many_to_many.MtMStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> updateCourse(Long id, Course course) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()) {
            optionalCourse.get().setName(course.getName());
            optionalCourse.get().setStudents(course.getMtmStudents());

            Course updatedCourse = courseRepository.save(optionalCourse.get());
            return Optional.of(updatedCourse);
        }

        return Optional.empty();
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
