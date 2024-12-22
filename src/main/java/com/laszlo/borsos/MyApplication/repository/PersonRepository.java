package com.laszlo.borsos.MyApplication.repository;

import com.laszlo.borsos.MyApplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getPersonById(int id);
}
