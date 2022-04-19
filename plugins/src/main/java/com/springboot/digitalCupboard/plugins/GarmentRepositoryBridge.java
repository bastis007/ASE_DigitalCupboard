package com.springboot.digitalCupboard.plugins;

import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.GarmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class    GarmentRepositoryBridge implements GarmentRepository {
    private final SpringDataGarmentRepository springDataGarmentRepository;

    @Autowired
    public GarmentRepositoryBridge(SpringDataGarmentRepository springDataGarmentRepository) {
        this.springDataGarmentRepository = springDataGarmentRepository;
    }

    @Override
    public List<Garment> findAll() {
        return springDataGarmentRepository.findAll();
    }

    @Override
    public Garment save(Garment garment) {
        return springDataGarmentRepository.save(garment);
    }

    @Override
    public Optional<Garment> findById(String id) {
        return springDataGarmentRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        springDataGarmentRepository.deleteById(id);
    }
}
