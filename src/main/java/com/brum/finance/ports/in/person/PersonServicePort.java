package com.brum.finance.ports.in.person;

import com.brum.finance.core.domain.entity.Person;
import java.util.UUID;

public interface PersonServicePort {
    Person createPerson(Person person);
    Person getPerson(UUID id);
    Person updatePerson(UUID id, Person person);
    void deletePerson(UUID id);
}
