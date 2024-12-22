package com.laszlo.borsos.MyApplication.controller;

import com.laszlo.borsos.MyApplication.entity.Person;
import com.laszlo.borsos.MyApplication.entity.PersonDto;
import com.laszlo.borsos.MyApplication.service.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    // dependency injection
    private final PersonServiceImpl personServiceImpl;

    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping
    public void createPerson(@RequestParam(value="name") String name, @RequestParam(value="pw")String pw){
        personServiceImpl.createPerson(name, pw);
    };

    @PostMapping("/json")
    public void createPerson(@RequestBody PersonDto personDto){
        personServiceImpl.createPerson(personDto.getName(), personDto.getPw());
    };

    @GetMapping("/data/{id}")
    public Person getPersonById(@PathVariable int id){
        return personServiceImpl.getPerson(id);
    };
}
