package com.eindopdracht.BE.ReneWeerts.Controller;

import com.eindopdracht.BE.ReneWeerts.Dto.PersonDto;
import com.eindopdracht.BE.ReneWeerts.Model.Person;
import com.eindopdracht.BE.ReneWeerts.Service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/persons")

public class PersonController {

    private final PersonService service;
    public PersonController(PersonService service) {
        this.service = service;

    }
    private final List<Person> persons = new ArrayList<>(); //new ArrayList is het object, persons is de naam van het object.

    @PostMapping
    public ResponseEntity <Object> createPerson (@RequestBody PersonDto personDto, BindingResult br) {
        //object is de moeder klasse van alle Java objecten en daar kunnen we in retourneren wat we willen
        if(br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField()).append(": ");
                sb.append(fe.getDefaultMessage()); //geef standaard foutmelding
                sb.append("\n"); //ga naar volgende regel

            }
            return ResponseEntity.badRequest().body(sb.toString());
        }
        else {
            Long newId = service.createPerson(personDto);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newId).toUriString());
            return ResponseEntity.created(uri).body(newId);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Person>> getPerson() {
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Person>> getPersonsById (@PathVariable Long id) {
        if (id > 0 && id < persons.size()) {
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePersonById (@RequestBody Person p, @PathVariable Long id) {
        if (id >= 0 && id < persons.size()) { // ID groter of gelijk aan nul, ID kleiner dan grote van lijst (-2,-3)
            persons.set(Math.toIntExact(id), p); // .set hiermee update je de arrayList van persons, geef (int) index mee en person element.
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            //error situation
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable int id) {
        if (id > 0 && id < persons.size()) {
            persons.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}