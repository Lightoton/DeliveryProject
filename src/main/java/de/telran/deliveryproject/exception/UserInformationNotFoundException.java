package de.telran.deliveryproject.exception;

public class UserInformationNotFoundException extends RuntimeException{
    public UserInformationNotFoundException(String message) {
        super(message);
    }
}
