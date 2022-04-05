package com.springboot.digitalCupboard.plugins;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.digitalCupboard.domain.Garment;

public interface SpringDataGarmentRepository extends JpaRepository<Garment, String> {
}
