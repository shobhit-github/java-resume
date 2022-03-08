package com.personal.javaresume;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import static com.personal.javaresume.utilities.constants.SwaggerConstant.APP_DESCRIPTION;
import static com.personal.javaresume.utilities.constants.SwaggerConstant.APP_TITLE;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = APP_TITLE, description = APP_DESCRIPTION, version = "1.0", contact = @Contact(name = "Shobhit Sharma", email = "shobhitmusic1@gmail.com")))
public class JavaResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaResumeApplication.class, args);
    }

}

