package com.springboot.digitalCupboard;

import com.springboot.digitalCupboard.domain.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigitalCupboardApplication {

    public static void main(String[] args){
        SpringApplication.run(DigitalCupboardApplication.class);
    }

    @Bean
    public CommandLineRunner demo(GarmentRepository repository) {
        return (args) -> {
            repository.save(new Garment("tshirt1", new Type("T-Shirt"), new Size("L"), new Colour("Green")));
            repository.save(new Garment("socks1", new Type("Socks"), new Size("44-46"), new Colour("Black")));
            repository.save(new Garment("jeans1", new Type("Jeans"), new Size("33/35"), new Colour("Blue")));
            repository.save(new Garment("hoodie1", new Type("Hoodie"), new Size("XL"), new Colour("Gray")));
            repository.save(new Garment("underpants1", new Type("Underpants"), new Size("L"), new Colour("Yellow")));
        };
    }
}
