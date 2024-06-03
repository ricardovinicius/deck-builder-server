package com.ricardo.deck_builder.person;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person save(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }
}
