package com.brum.finance.infrastructure.inbound.api;

import com.brum.finance.core.domain.entity.Person;
import com.brum.finance.ports.in.person.PersonServicePort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonEndpointAdapter {

    private final PersonServicePort personServicePort;

    @PostMapping()
    public Person createPerson(@RequestBody Person person) {
        return personServicePort.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") UUID id) {
        return personServicePort.getPerson(id);
    }

    @PatchMapping("/{id}")
    public Person updatePerson(@PathVariable("id") UUID id, Person person) {
        return personServicePort.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personServicePort.deletePerson(id);
    }
}
