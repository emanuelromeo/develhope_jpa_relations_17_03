package com.crud.jpa_relations_17_03.service.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Student;
import com.crud.jpa_relations_17_03.repository.one_to_one.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setName(student.getName());

            Student updatedStudent = studentRepository.save(optionalStudent.get());
            return Optional.of(updatedStudent);
        }

        return Optional.empty();
    }

    public Optional<Student> deleteStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setDeleted(true);

            Student deletedStudent = studentRepository.save(optionalStudent.get());
            return Optional.of(deletedStudent);
        }

        return Optional.empty();
    }
}
