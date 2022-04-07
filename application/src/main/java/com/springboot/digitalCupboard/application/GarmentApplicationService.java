package com.springboot.digitalCupboard.application;

import com.springboot.digitalCupboard.domain.GarmentRepository;
import com.springboot.digitalCupboard.domain.Garment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarmentApplicationService {

    private final GarmentRepository garmentRepository;

    @Autowired
    public GarmentApplicationService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    public List<Garment> findAll() {
        return this.garmentRepository.findAll();
    }

    public Optional<Garment> findById(String id) {
        return garmentRepository.findById(id);
    }

    public Garment save(Garment newGarment) {
        return garmentRepository.save(newGarment);
    }

    public void deleteById(String id) {
        garmentRepository.deleteById(id);
    }
}
