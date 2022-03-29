package com.springboot.digitalCupboard.adapters.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.domain.Garment;

@Component
public class GarmentToRepresentationMapper implements Function<Garment, GarmentRepresentation> {

    @Override
    public GarmentRepresentation apply(Garment garment) {
        return new GarmentRepresentation(
                garment.getId(),
                garment.getType(),
                garment.getSize(),
                garment.getColour());
    }
}
