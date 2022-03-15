package com.springboot.digitalCupboard;

import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.GarmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DigitalCupboardApplication {

    private static final Logger log = LoggerFactory.getLogger(DigitalCupboardApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DigitalCupboardApplication.class);
    }

    @Bean
    public CommandLineRunner demo(GarmentRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Garment("tshirt1", "T-Shirt", "L", "Green"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Garment garment : repository.findAll()) {
                log.info(garment.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<Garment> garment = repository.findById("tshirt1");
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(garment.toString());
            log.info("");
            log.info("");
        };
    }
}
