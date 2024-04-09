package de.telran.deliveryproject.exception;

public class UserInformationIsExistException extends RuntimeException{
    public UserInformationIsExistException(String message) {
        super(message);
    }
}
