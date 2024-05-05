package ru.skypro.homework_4_5_parallelstreams.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(String message) {

        super(message);
    }
}
