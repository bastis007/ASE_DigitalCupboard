package com.springboot.digitalCupboard;

import com.springboot.digitalCupboard.domain.Colour;
import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.Size;
import com.springboot.digitalCupboard.domain.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarmentTest {

    @Test
    @DisplayName("Test toString-method")
    void testToString() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        String expected = "Customer[id='" + garment.getId() + "', type='" + garment.getType() + "', size='" + garment.getSize() + "', colour='" + garment.getColour() + "']";
        String result = garment.toString();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(id)")
    void testGetId() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        String expected = "tshirt1";
        String result = garment.getId();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(type)")
    void testGetType() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        String expected = "T-Shirt";
        String result = garment.getType().toString();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(size)")
    void testGetSize() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        String expected = "L";
        String result = garment.getSize().toString();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Getter(colour)")
    void testGetColour() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        Colour expected = new Colour("Red");
        Colour result = garment.getColour();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Setter(size)")
    void testSetSize() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        garment.setSize(new Size("XL"));
        String expected = "XL";
        String result = garment.getSize().toString();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Setter(colour)")
    void testSetColour() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        garment.setColour(new Colour("Green"));
        Colour expected = new Colour("Green");
        Colour result = garment.getColour();
        assertEquals(expected, result);
    }
}