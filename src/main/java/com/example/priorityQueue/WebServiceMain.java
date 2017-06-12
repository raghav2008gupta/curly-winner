package com.example.priorityQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WebServiceMain.java - A class with main method to start web service on port
 * 8080 of the server
 *
 * @author Raghav Gupta
 * @version 1.0
 */
@SpringBootApplication
public class WebServiceMain {

	/**
	 * Main method to launch Web Service
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebServiceMain.class, args);
	}
}
