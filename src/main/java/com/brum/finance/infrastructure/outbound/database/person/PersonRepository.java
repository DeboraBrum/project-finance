package com.brum.finance.infrastructure.outbound.database.person;

import com.brum.finance.core.domain.entity.Person;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
