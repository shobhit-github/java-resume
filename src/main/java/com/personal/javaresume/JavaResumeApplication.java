package com.personal.javaresume;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Resume - Documentation", description = "This is a backend application to manage personal resume content", version = "1.0", contact = @Contact(name = "Shobhit Sharma", email = "shobhitmusic1@gmail.com")))
public class JavaResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaResumeApplication.class, args);
    }

}

