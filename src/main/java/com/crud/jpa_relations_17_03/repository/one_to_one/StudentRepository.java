package com.crud.jpa_relations_17_03.repository.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
