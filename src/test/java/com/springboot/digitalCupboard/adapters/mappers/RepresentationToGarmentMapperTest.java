package com.springboot.digitalCupboard.adapters.mappers;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.domain.Garment;
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
    void apply() {
        GarmentRepresentation given = new GarmentRepresentation("tshirt1", "T-Shirt", "L", "Red");

        Garment then = toBeTested.apply(given);

        Assertions.assertNotNull(then);
        Assertions.assertEquals("tshirt1", then.getId());
        Assertions.assertEquals("T-Shirt", then.getType());
        Assertions.assertEquals("L", then.getSize());
        Assertions.assertEquals("Red", then.getColour());
    }

    @Test
    @DisplayName("Update old Garment with new GarmentRepresentation")
    public void update() {
        Garment oldGarment = new Garment("tshirt1", "T-Shirt", "L", "Red");
        GarmentRepresentation newGarment = new GarmentRepresentation("tshirt1", "T-Shirt", "XL", "Green");

        Garment then = toBeTested.update(oldGarment, newGarment);

        Assertions.assertNotNull(then);
        Assertions.assertEquals("tshirt1", then.getId());
        Assertions.assertEquals("T-Shirt", then.getType());
        Assertions.assertEquals("XL", then.getSize());
        Assertions.assertEquals("Green", then.getColour());
    }
}