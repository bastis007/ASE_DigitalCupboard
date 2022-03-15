package com.springboot.digitalCupboard.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GarmentRepository {

    List<Garment> findAll();

    Garment save(Garment garment);

    Optional<Garment> findById(String id);

    Garment deleteById(String id);
}
