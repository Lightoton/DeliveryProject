package de.telran.deliveryproject.exception;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException(String message) {
        super(message);
    }
}
