package com.springboot.digitalCupboard;

import com.springboot.digitalCupboard.application.GarmentApplicationService;
import com.springboot.digitalCupboard.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GarmentApplicationServiceTest {
    @InjectMocks
    GarmentApplicationService toBeTested;
    @Mock
    GarmentRepository mockRepository;

    @Test
    @DisplayName("Test ApplicationService.findAll")
    void testFindAll() {
        Garment garment0 = new Garment("jeans1", new Type("Jeans"), new Size("33/35"), new Colour("Blue"));
        Garment garment1 = new Garment("socks1", new Type("Socks"), new Size("44-46"), new Colour("Black"));
        Garment garment2 = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));

        when(mockRepository.findAll()).thenReturn(Arrays.asList(garment0, garment1, garment2));
        List<Garment> whenReturn = toBeTested.findAll();

        Assertions.assertEquals("jeans1", whenReturn.get(0).getId());
        Assertions.assertEquals("socks1", whenReturn.get(1).getId());
        Assertions.assertEquals("tshirt1", whenReturn.get(2).getId());
    }

    @Test
    @DisplayName("Test ApplicationService.findById")
    void testFindById() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));

        when(mockRepository.findById(garment.getId())).thenReturn(Optional.of(garment));
        Optional<Garment> whenReturn = toBeTested.findById(garment.getId());

        Assertions.assertEquals(garment.getId(), whenReturn.get().getId());
    }

    @Test
    @DisplayName("Test ApplicationService.save")
    void testSave() {
        Garment newGarment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));
        lenient().when(mockRepository.findAll()).thenReturn(List.of(new Garment("tshirt1", new Type("T-Shirt"), new Size("XL"), new Colour("Green"))));
        lenient().when(mockRepository.save(newGarment)).thenReturn(newGarment);
        Garment returnVal = toBeTested.save(newGarment);

        Assertions.assertEquals("tshirt1", returnVal.getId());
        Assertions.assertEquals("L", returnVal.getSize());
        Assertions.assertEquals("Red", returnVal.getColour());
    }

    @Test
    @DisplayName("Test ApplicationService.deleteById")
    void testDeleteById() {
        Garment garment = new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Red"));

        lenient().when(mockRepository.findById(garment.getId())).thenReturn(Optional.of(garment));

        toBeTested.deleteById(garment.getId());

        verify(mockRepository, Mockito.times(1)).deleteById(any());
    }
}