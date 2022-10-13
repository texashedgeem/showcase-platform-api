package com.showcase.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * {@code NotFoundException} is the subclass of those
 * checked exceptions that can be thrown when an object is not present in the DB.
 */
public class NotFoundException extends ResponseStatusException {
    public NotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
