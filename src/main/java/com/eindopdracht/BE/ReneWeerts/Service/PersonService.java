package com.eindopdracht.BE.ReneWeerts.Service;

import com.eindopdracht.BE.ReneWeerts.Dto.PersonDto;
import com.eindopdracht.BE.ReneWeerts.Model.Person;
import com.eindopdracht.BE.ReneWeerts.Repository.PersonRepository;
import org.springframework.stereotype.Service;



@Service
public class PersonService {
    private final PersonRepository repos; // Final mag je alleen in een constructor zetten en deze kan niet veranderen.

    public PersonService(PersonRepository repos) { // dependency injection via constructor.(bij testen kunnen we autowired gebruiken)
        this.repos = repos;
    }


    public Long createPerson(PersonDto personDto) {
        Person person = new Person();  // eerst een person object maken
        person.setFirstName(personDto.firstName);
        person.setLastName(personDto.lastName);
        person.setEmail(personDto.email);
        person.setPhoneNumber(personDto.phoneNumber); //dit kan ook met object mapper/beanUtil (automatische invulling)
        repos.save(person);
        return person.getId();
    }

}
