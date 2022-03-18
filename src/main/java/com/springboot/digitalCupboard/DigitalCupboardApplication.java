package com.springboot.digitalCupboard;

import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.GarmentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;


@SpringBootApplication
public class DigitalCupboardApplication {

    //private static final Logger log = LoggerFactory.getLogger(DigitalCupboardApplication.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(DigitalCupboardApplication.class);
    }

    @Bean
    public CommandLineRunner demo(GarmentRepository repository) {
        return (args) -> {
            repository.save(new Garment("tshirt1", "T-Shirt", "L", "Green"));
            repository.save(new Garment("socks1", "Socks", "44-46", "Black"));
            repository.save(new Garment("jeans1", "Jeans", "33/35", "Blue"));
            repository.save(new Garment("hoodie1", "Hoodie", "XL", "Gray"));
            repository.save(new Garment("underpants1", "Underpants", "L", "Yellow"));
        };
    }
}
