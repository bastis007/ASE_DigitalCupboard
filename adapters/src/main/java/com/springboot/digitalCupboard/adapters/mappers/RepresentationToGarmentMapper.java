package com.springboot.digitalCupboard.adapters.mappers;

import java.util.function.Function;

import com.springboot.digitalCupboard.domain.Colour;
import com.springboot.digitalCupboard.domain.Size;
import com.springboot.digitalCupboard.domain.Type;
import org.springframework.stereotype.Component;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.domain.Garment;

@Component
public class RepresentationToGarmentMapper implements Function<GarmentRepresentation, Garment>{

    @Override
    public Garment apply(GarmentRepresentation garmentRepresentation) {
        return new Garment(
                garmentRepresentation.getId(),
                new Type(garmentRepresentation.getType()),
                new Size(garmentRepresentation.getSize()),
                new Colour(garmentRepresentation.getColour()));
    }

    public Garment update(Garment oldGarment, GarmentRepresentation newGarment) {
        return new Garment(
                oldGarment.getId(),
                oldGarment.getType(),
                new Size(newGarment.getSize()),
                new Colour(newGarment.getColour()));
    }

    private String pickNewIfDefined(String oldValue, String newValue) {
        return replaceNullWithUndefined(newValue).equals("undefined") ? oldValue : newValue;
    }

    private String replaceNullWithUndefined(String oldValue) {
        return oldValue == null ? "undefined" : oldValue;
    }

}
