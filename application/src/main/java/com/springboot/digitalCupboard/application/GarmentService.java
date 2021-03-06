package com.springboot.digitalCupboard.application;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.GarmentRepository;

@Service
@Scope("singleton")
public class GarmentService {
    private final GarmentRepository garmentRepository;

    @Autowired
    public GarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    public List<Garment> findAll() {
        return garmentRepository.findAll()
                .stream().sorted(Comparator.comparing(Garment::getId))
                .collect(Collectors.toList());
    }

    public Garment save(Garment garment) {
        return garmentRepository.save(garment);
    }

    public Optional<Garment> findById(String id) {
        return garmentRepository.findById(id);
    }

    public void deleteById(String id) {
        Optional<Garment> toBeDeleted = garmentRepository.findById(id);
        if (toBeDeleted.isEmpty()) {
            return;
        }
        garmentRepository.deleteById(id);
    }
}
