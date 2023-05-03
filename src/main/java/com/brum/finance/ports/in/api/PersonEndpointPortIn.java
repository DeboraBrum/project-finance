package com.brum.finance.ports.in.api;

import com.brum.finance.core.domain.entity.Person;
import java.util.Optional;
import java.util.UUID;

public interface PersonEndpointPortIn {
    Person createPerson(UUID id, Person person);
    Person getPerson(UUID id);
    Person updatePerson(UUID id, Person person);
    void deletePerson(UUID id);
}
