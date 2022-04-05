package com.springboot.digitalCupboard.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarmentTest {

    @Test
    @DisplayName("Test toString-method")
    void testToString() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Customer[id='" + garment.getId() + "', type='" + garment.getType() + "', size='" + garment.getSize() + "', colour='" + garment.getColour() + "']";
        String result = garment.toString();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(id)")
    void testGetId() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "tshirt1";
        String result = garment.getId();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(type)")
    void testGetType() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "T-Shirt";
        String result = garment.getType();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(size)")
    void testGetSize() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "L";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(colour)")
    void testGetColour() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Red";
        String result = garment.getColour();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Setter(size)")
    void testSetSize() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        garment.setSize("XL");
        String expected = "XL";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Setter(colour)")
    void testSetColour() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        garment.setColour("Green");
        String expected = "Green";
        String result = garment.getColour();
        assertEquals(expected, result);
    }
}