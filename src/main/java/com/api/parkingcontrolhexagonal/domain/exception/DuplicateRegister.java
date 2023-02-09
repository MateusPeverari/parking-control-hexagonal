package com.api.parkingcontrolhexagonal.domain.exception;

public class DuplicateRegister extends RuntimeException {
    public DuplicateRegister(String message) {
        super(message);
    }
}
