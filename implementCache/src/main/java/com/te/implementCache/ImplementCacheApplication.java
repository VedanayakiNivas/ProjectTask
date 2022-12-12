package com.te.implementCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ImplementCacheApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ImplementCacheApplication.class, args);
	}

}
