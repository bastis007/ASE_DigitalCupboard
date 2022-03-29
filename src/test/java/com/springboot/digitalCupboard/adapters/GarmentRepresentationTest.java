package com.springboot.digitalCupboard.adapters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GarmentRepresentationTest {

    @Test
    @DisplayName("Test GarmentRepresentationGetter(id)")
    void testGetId() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "tshirt1";
        String result = garment.getId();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test GarmentRepresentationGetter(type)")
    void testGetType() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "T-Shirt";
        String result = garment.getType();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test GarmentRepresentationGetter(size)")
    void testGetSize() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "L";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test GarmentRepresentationGetter(colour)")
    void testGetColour() {
        GarmentRepresentation garment = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Red";
        String result = garment.getColour();
        assertEquals(expected, result);
    }
}