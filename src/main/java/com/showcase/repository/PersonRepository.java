package com.showcase.repository;

import com.showcase.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code PersonRepository} JPA object to make CRUD operations with PersonEntity
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
