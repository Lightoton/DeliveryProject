package de.telran.deliveryproject.exception;

public class CourierNotFoundException extends RuntimeException{
    public CourierNotFoundException(String message) {
        super(message);
    }
}