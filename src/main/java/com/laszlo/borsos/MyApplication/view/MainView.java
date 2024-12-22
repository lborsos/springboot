package com.laszlo.borsos.MyApplication.view;

import com.laszlo.borsos.MyApplication.entity.Person;
import com.laszlo.borsos.MyApplication.service.PersonServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("/")
public class MainView extends VerticalLayout {
    private final TextField nameField = new TextField("Name");
    private final TextField passwordField = new TextField("Password");
    private final Button saveButton = new Button("Save");
    private final Grid<Person> personGrid = new Grid<>(Person.class);

    @Autowired
    public MainView(PersonServiceImpl personServiceImpl) {
        add(nameField, passwordField, saveButton, personGrid);

        saveButton.addClickListener(event -> {
            String name = nameField.getValue();
            String password = passwordField.getValue();

            personServiceImpl.createPerson(name, password);

            List<Person> persons = personServiceImpl.getAllPersons();
            personGrid.setItems(persons);

            nameField.clear();
            passwordField.clear();
        });

        personGrid.setColumns("id", "name", "password");
        personGrid.setItems(personServiceImpl.getAllPersons());
    }
}
