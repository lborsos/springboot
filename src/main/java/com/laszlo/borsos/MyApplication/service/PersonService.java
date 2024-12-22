package com.laszlo.borsos.MyApplication.service;

import com.laszlo.borsos.MyApplication.entity.Person;

public interface PersonService {
    void createPerson(String name, String pw);
    Person getPerson(int id);
}
