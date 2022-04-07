package com.springboot.digitalCupboard.adapters.mappers;

import com.springboot.digitalCupboard.adapters.GarmentRepresentation;
import com.springboot.digitalCupboard.domain.Garment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class GarmentToRepresentationMapperTest {
    @Mock
    private GarmentToRepresentationMapper garmentToRepresentationMapper;
    @InjectMocks
    private GarmentToRepresentationMapper toBeTested;

    @Test
    @DisplayName("Garment to Representation Mapper simple Test")
    public void testApplySuccessfully() {
        Garment garment = new Garment("tshirt1", "T-Shirt", "L", "Red");

        lenient().when(garmentToRepresentationMapper.apply(garment))
                .thenReturn(new GarmentRepresentation(
                    garment.getId(),
                    garment.getType(),
                    garment.getSize(),
                    garment.getColour()));
        GarmentRepresentation mapped = toBeTested.apply(garment);

        Assertions.assertNotNull(mapped);
        Assertions.assertEquals("tshirt1", mapped.getId());
        Assertions.assertEquals("T-Shirt", mapped.getType());
        Assertions.assertEquals("L", mapped.getSize());
        Assertions.assertEquals("Red", mapped.getColour());
    }
}