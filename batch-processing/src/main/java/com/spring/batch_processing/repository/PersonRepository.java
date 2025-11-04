package com.spring.batch_processing.repository;

import com.spring.batch_processing.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
