package dev.omyshko.datahub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataHubApplication {

    public static void main(String[] args) {
        System.out.println("App started");
        SpringApplication.run(DataHubApplication.class, args);
    }

}
