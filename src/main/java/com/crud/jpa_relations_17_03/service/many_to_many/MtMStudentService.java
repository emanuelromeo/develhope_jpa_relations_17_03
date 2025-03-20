package com.crud.jpa_relations_17_03.service.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.MtMStudent;
import com.crud.jpa_relations_17_03.repository.many_to_many.MtMStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MtMStudentService {

    @Autowired
    private MtMStudentRepository studentRepository;

    public MtMStudent saveStudent(MtMStudent student) {
        return studentRepository.save(student);
    }

    public Optional<MtMStudent> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<MtMStudent> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<MtMStudent> updateStudent(Long id, MtMStudent student) {
        Optional<MtMStudent> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setName(student.getName());

            MtMStudent updatedStudent = studentRepository.save(optionalStudent.get());
            return Optional.of(updatedStudent);
        }

        return Optional.empty();
    }

    public Optional<MtMStudent> deleteStudentById(Long id) {
        Optional<MtMStudent> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setDeleted(true);

            MtMStudent deletedStudent = studentRepository.save(optionalStudent.get());
            return Optional.of(deletedStudent);
        }

        return Optional.empty();
    }
}
