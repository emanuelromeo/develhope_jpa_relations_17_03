package com.crud.jpa_relations_17_03.repository.many_to_many;

import com.crud.jpa_relations_17_03.entity.many_to_many.MtMStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface MtMStudentRepository extends JpaRepository<MtMStudent, Long> {
    @Query(value = """
            SELECT c.mtmStudents
            FROM Course c
            WHERE c.id = :courseId
            """)
    Page<MtMStudent> findByCourseId(@Param("courseId") Long courseId, Pageable pageable);
}
