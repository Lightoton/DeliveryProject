package de.telran.deliveryproject.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;




@OpenAPIDefinition(
        info = @Info(
                title = "Delivery project",
                description = "This is a prototype of a restaurant delivery service backend.", version = "0.3.0",
                contact = @Contact(
                        name = "Viktor Bulatov",
                        email = "viktorbulatov997@gmail.com",
                        url = "https://github.com/Lightoton"
                )
        )
)

public class SwaggerConfig {

    @Value("${variables.projectPackageName=de.telran.deliveryproject.controller}")
    private String PACKAGE_NAME;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_NAME))
                .paths(PathSelectors.any())
                .build();
    }
}
