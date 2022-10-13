package com.showcase.api;

import com.showcase.model.PersonOas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        value = "/api"
)
public class ShowcaseRestController {
    private final ShowcaseService showcaseService;

    @GetMapping("/showcase")
    public Mono<ResponseEntity<List<PersonOas>>> getAll() {
        return Mono.just(ResponseEntity.ok(showcaseService.getAllPerson()));
    }

    @GetMapping("/showcase/{personId}")
    public Mono<ResponseEntity<PersonOas>> get(@PathVariable(value = "personId") UUID personId) {
        return Mono.just(ResponseEntity.ok(showcaseService.getPerson(personId)));
    }

    @PostMapping("/showcase")
    public Mono<ResponseEntity<PersonOas>> post(@Valid @RequestBody PersonOas personOas) {
        var savedPerson = showcaseService.savePerson(personOas);
        return Mono.just(
                ResponseEntity.status(HttpStatus.CREATED)
                        .body(savedPerson)
        );
    }
}
