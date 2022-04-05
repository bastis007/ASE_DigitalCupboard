package com.springboot.digitalCupboard.adapters.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.domain.Garment;

@Component
public class RepresentationToGarmentMapper implements Function<GarmentRepresentation, Garment>{

    @Override
    public Garment apply(GarmentRepresentation garmentRepresentation) {
        return new Garment(
                garmentRepresentation.getId(),
                garmentRepresentation.getType(),
                garmentRepresentation.getSize(),
                garmentRepresentation.getColour());
    }

    public Garment update(Garment oldGarment, GarmentRepresentation newGarment) {
        return new Garment(
                oldGarment.getId(),
                oldGarment.getType(),
                pickNewIfDefined(oldGarment.getSize(), newGarment.getSize()),
                pickNewIfDefined(oldGarment.getColour(), newGarment.getColour()));
    }

    private String pickNewIfDefined(String oldValue, String newValue) {
        return replaceNullWithUndefined(newValue).equals("undefined") ? oldValue : newValue;
    }

    private String replaceNullWithUndefined(String oldValue) {
        return oldValue == null ? "undefined" : oldValue;
    }

}
