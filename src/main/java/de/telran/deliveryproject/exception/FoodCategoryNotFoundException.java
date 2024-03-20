package de.telran.deliveryproject.exception;

public class FoodCategoryNotFoundException extends RuntimeException{
    public FoodCategoryNotFoundException(String message) {
        super(message);
    }
}
