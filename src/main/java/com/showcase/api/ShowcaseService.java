package com.showcase.api;

import com.showcase.api.exception.NotFoundException;
import com.showcase.model.PersonEntity;
import com.showcase.model.PersonOas;
import com.showcase.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShowcaseService {

    private final ShowcaseMapper showcaseMapper;
    private final PersonRepository personRepository;

    PersonOas getPerson(UUID id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            log.info("Person not found with id [{}]", id);
            throw new NotFoundException("Person Not Found id " + id);
        }
        return showcaseMapper.toPersonOas(personEntityOptional.get());
    }

    List<PersonOas> getAllPerson(){
        List<PersonEntity> personEntities = personRepository.findAll();
        return showcaseMapper.toPersonOasList(personEntities);
    }

    PersonOas savePerson(PersonOas personOas) {
        var personEntity = showcaseMapper.toPersonEntity(personOas);
        var personStored = personRepository.save(personEntity);
        return showcaseMapper.toPersonOas(personStored);
    }
}
