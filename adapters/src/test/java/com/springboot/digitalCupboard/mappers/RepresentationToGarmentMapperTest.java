package com.springboot.digitalCupboard.mappers;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.adapters.mappers.RepresentationToGarmentMapper;
import com.springboot.digitalCupboard.domain.Colour;
import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.Size;
import com.springboot.digitalCupboard.domain.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RepresentationToGarmentMapperTest {
    @InjectMocks
    private RepresentationToGarmentMapper toBeTested;

    @Test
    @DisplayName("Representation to Garment Mapper Test")
    void testApply() {
        GarmentRepresentation given = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");

        Garment then = toBeTested.apply(given);

        Assertions.assertNotNull(then);
        Assertions.assertEquals("tshirt1", then.getId());
        Assertions.assertEquals(new Type("T-Shirt"), then.getType());
        Assertions.assertEquals(new Size("L"), then.getSize());
        Assertions.assertEquals(new Colour("Red"), then.getColour());
    }

    @Test
    @DisplayName("Update old Garment with new GarmentRepresentation")
    public void testUpdate() {
        Garment oldGarment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        GarmentRepresentation newGarment = new GarmentRepresentation("tshirt1", "T-Shirt", "XL", "Green");

        Garment then = toBeTested.update(oldGarment, newGarment);

        Assertions.assertNotNull(then);
        Assertions.assertEquals("tshirt1", then.getId());
        Assertions.assertEquals(new Type("T-Shirt"), then.getType());
        Assertions.assertEquals(new Size("XL"), then.getSize());
        Assertions.assertEquals(new Colour("Green"), then.getColour());
    }
}