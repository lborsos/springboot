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

@Route
public class MainView extends VerticalLayout {
    private final TextField nameField = new TextField("Name");
    private final TextField passwordField = new TextField("Password");
    private final Button saveButton = new Button("Save");
    private final Grid<Person> personGrid = new Grid<>(Person.class);

    @Autowired
    public MainView(PersonServiceImpl personServiceImpl) {
        // Set up layout
        add(nameField, passwordField, saveButton, personGrid);

        // Save button logic
        saveButton.addClickListener(event -> {
            String name = nameField.getValue();
            String password = passwordField.getValue();

            // Save data via service
            personServiceImpl.createPerson(name, password);

            // Update grid with all data from the database
            List<Person> persons = personServiceImpl.getAllPersons();
            personGrid.setItems(persons);

            // Clear fields
            nameField.clear();
            passwordField.clear();
        });

        // Initial grid population
        personGrid.setColumns("id", "name", "password");
        personGrid.setItems(personServiceImpl.getAllPersons());
    }
}
