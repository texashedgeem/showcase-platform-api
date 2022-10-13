package com.showcase.api;

import com.showcase.model.PersonEntity;
import com.showcase.model.PersonOas;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@code ShowcaseMapper} Mapper class to convert from PersonEntity
 * to PersonOas objects and vice-versa
 */
@Service
public class ShowcaseMapper {

    PersonEntity toPersonEntity(PersonOas personOas) {
        return PersonEntity.builder()
                .userName(personOas.getUserName())
                .bankAccount(personOas.getBankAccount())
                .createdAt(Instant.now())
                .status(Optional.ofNullable(personOas.getStatus()).orElse("ONLINE"))
                .build();
    }

    PersonOas toPersonOas(PersonEntity personEntity) {
        return PersonOas.builder()
                .id(personEntity.getId())
                .userName(personEntity.getUserName())
                .bankAccount(personEntity.getBankAccount())
                .status(personEntity.getStatus())
                .createdAt(personEntity.getCreatedAt())
                .build();
    }

    List<PersonOas> toPersonOasList(List<PersonEntity> personOasList){
        return personOasList
                .stream()
                .map(this::toPersonOas)
                .collect(Collectors.toList());
    }
}
