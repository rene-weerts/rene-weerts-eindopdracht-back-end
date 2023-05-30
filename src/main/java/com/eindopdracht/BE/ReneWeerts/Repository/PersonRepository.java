package com.eindopdracht.BE.ReneWeerts.Repository;

import com.eindopdracht.BE.ReneWeerts.Model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {



}
