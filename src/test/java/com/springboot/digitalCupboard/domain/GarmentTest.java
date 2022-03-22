package com.springboot.digitalCupboard.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.springboot.digitalCupboard.domain.Garment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GarmentTest {

    @Test
    void testToString() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Customer[id='" + garment.getId() + "', type='" + garment.getType() + "', size='" + garment.getSize() + "', colour='" + garment.getColour() + "']";
        String result = garment.toString();
        assertEquals(expected, result);
    }

    @Test
    void getId() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "tshirt1";
        String result = garment.getId();
        assertEquals(expected, result);
    }

    @Test
    void getType() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "T-Shirt";
        String result = garment.getType();
        assertEquals(expected, result);
    }

    @Test
    void getSize() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "L";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    void getColour() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        String expected = "Red";
        String result = garment.getColour();
        assertEquals(expected, result);
    }

    @Test
    void setSize() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        garment.setSize("XL");
        String expected = "XL";
        String result = garment.getSize();
        assertEquals(expected, result);
    }

    @Test
    void setColour() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        garment.setColour("Green");
        String expected = "Green";
        String result = garment.getColour();
        assertEquals(expected, result);
    }
}