package com.crud.jpa_relations_17_03.repository.one_to_one;

import com.crud.jpa_relations_17_03.entity.one_to_one.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
