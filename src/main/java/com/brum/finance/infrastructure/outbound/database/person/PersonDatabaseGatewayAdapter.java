package com.brum.finance.infrastructure.outbound.database.person;

import com.brum.finance.core.domain.entity.Person;
import com.brum.finance.ports.out.PersonDatabaseGatewayPort;
import java.util.Optional;
import java.util.UUID;

public class PersonDatabaseGatewayAdapter implements PersonDatabaseGatewayPort {

    private final PersonRepository personRepository;

    public PersonDatabaseGatewayAdapter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createDbPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getDbPerson(UUID id) {
        return personRepository.findById(id);
    }

    @Override
    public Person updateDbPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteDbPerson(UUID id) {
        personRepository.deleteById(id);
    }
}
