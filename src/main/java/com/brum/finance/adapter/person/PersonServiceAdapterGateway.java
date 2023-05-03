package com.brum.finance.adapter.person;

import com.brum.finance.core.domain.entity.Person;
import com.brum.finance.core.domain.exception.common.NotFoundException;
import com.brum.finance.ports.in.person.PersonServicePort;
import com.brum.finance.ports.out.PersonDatabaseGatewayPort;
import java.util.UUID;

public class PersonServiceAdapterGateway implements PersonServicePort {

    private final PersonDatabaseGatewayPort personDatabaseGatewayPort;

    public PersonServiceAdapterGateway(PersonDatabaseGatewayPort personDatabaseGatewayPort) {
        this.personDatabaseGatewayPort = personDatabaseGatewayPort;
    }

    @Override
    public Person createPerson(Person person) {
        return personDatabaseGatewayPort.createDbPerson(person);
    }

    @Override
    public Person getPerson(UUID id) {
        return personDatabaseGatewayPort.getDbPerson(id).orElseThrow(()-> new NotFoundException("Not Found"));
    }

    @Override
    public Person updatePerson(UUID id, Person person) {
        Person oldPerson = getPerson(id);
        // fazer alguma lógica de update
        return personDatabaseGatewayPort.updateDbPerson(person);
    }

    @Override
    public void deletePerson(UUID id) {
        personDatabaseGatewayPort.deleteDbPerson(id);
    }
}
