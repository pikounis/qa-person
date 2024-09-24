package com.qa.PersonProject.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person does not exist with that ID")
public class PersonNotFoundException extends EntityNotFoundException {

}
