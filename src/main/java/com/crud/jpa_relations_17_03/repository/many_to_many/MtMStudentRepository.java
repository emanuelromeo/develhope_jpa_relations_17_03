package com.crud.jpa_relations_17_03.repository.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.MtMStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtMStudentRepository extends JpaRepository<MtMStudent, Long> {
}
