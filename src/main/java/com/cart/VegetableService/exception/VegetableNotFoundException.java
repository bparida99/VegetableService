package com.cart.VegetableService.exception;

public class VegetableNotFoundException extends RuntimeException{

    public VegetableNotFoundException(String message){
        super(message);
    }
}
