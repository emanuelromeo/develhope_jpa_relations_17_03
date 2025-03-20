package com.crud.jpa_relations_17_03.repository.one_to_many;

import com.crud.jpa_relations_17_03.entity.one_to_many.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
