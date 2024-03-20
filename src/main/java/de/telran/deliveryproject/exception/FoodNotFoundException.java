package de.telran.deliveryproject.exception;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException(String message) {
        super(message);
    }
}
