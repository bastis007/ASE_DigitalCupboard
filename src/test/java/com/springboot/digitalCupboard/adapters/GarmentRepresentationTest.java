package com.springboot.digitalCupboard.adapters;

import com.springboot.digitalCupboard.domain.Garment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GarmentRepresentationTest {

    @Test
    void getId() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "tshirt1";
        String result = garment.getId();
        assertEquals(expected, result);
    }

    @Test
    void getType() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "T-Shirt";
        String result = garment.getType();
        assertEquals(expected, result);
    }

    @Test
    void getSize() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "L";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    void getColour() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Red";
        String result = garment.getColour();
        assertEquals(expected, result);
    }
}