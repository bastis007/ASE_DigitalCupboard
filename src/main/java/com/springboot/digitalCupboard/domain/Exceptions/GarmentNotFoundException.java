package com.springboot.digitalCupboard.domain.exceptions;

@SuppressWarnings("serial")
public class GarmentNotFoundException extends RuntimeException {

    public GarmentNotFoundException(String id) {
        super("Could not find Garment " + id);
    }

}
