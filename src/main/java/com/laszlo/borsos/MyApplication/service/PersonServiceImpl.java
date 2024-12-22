package com.laszlo.borsos.MyApplication.service;

import com.laszlo.borsos.MyApplication.entity.Person;
import com.laszlo.borsos.MyApplication.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(String name, String pw){
        Person person = new Person();
        person.setName(name);
        person.setPassword(pw);
        personRepository.save(person);
    }

    public Person getPerson(int id){
        return personRepository.getPersonById(id);
    }
}
