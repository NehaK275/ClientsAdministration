package com.clientsadministration.exceptions;

public class InvalidCompanyIdException extends RuntimeException{
    public InvalidCompanyIdException() {
        super("Company with matching id not found!");
    }
}
