package com.example.crud.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class InventoryConfig {
    @Bean
    CommandLineRunner commandLineRunner(InventoryRepository repository){
        return args -> {
            Inventory item1 = new Inventory(
                    "item1",
                    "I001",
                    100
            );
            Inventory item2 = new Inventory(
                    "item2",
                    "I002",
                    150
            );
            Inventory item3 = new Inventory(
                    "item3",
                    "I003",
                    200
            );

            repository.saveAll(
                    List.of(item1, item2, item3)
            );
        };
    }
}
