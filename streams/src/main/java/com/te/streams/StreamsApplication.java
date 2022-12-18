package com.te.streams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class StreamsApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

}
