package com.example.kafkabinderreproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class KafkaBinderReproducerApplication {

    private static final Logger logger = LoggerFactory.getLogger(KafkaBinderReproducerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaBinderReproducerApplication.class, args);
	}

    private Random random = new Random();

    @Bean
    public Supplier<String> producer() {
        return () -> "Demo from Streams - " + random.nextInt(1000);
    }

    @Bean
    public Consumer<String> consumer() {
        return message -> logger.info("Received: " + message);
    }
}
