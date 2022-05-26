package uz.oyatjon.unittesting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class UnittestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnittestingApplication.class, args);
    }

}
