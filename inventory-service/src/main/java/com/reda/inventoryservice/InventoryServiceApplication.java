package com.reda.inventoryservice;

import com.reda.inventoryservice.entities.Product;
import com.reda.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Computer")
							.price(20000)
							.quantity(12)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Printer")
					.price(5000)
					.quantity(5)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Iphone 15")
					.price(20000)
					.quantity(20)
					.build());
		};
	}
}


