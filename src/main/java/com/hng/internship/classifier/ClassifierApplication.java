package com.hng.internship.classifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class ClassifierApplication {

	@Bean
	public RestClient restClient(){
		return  RestClient.create();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClassifierApplication.class, args);
	}

}
