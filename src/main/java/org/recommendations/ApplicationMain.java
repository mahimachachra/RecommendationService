package org.recommendations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        //Create all beans for the respective annotated classes and start my spring application
        SpringApplication.run(ApplicationMain.class, args);
    }
}