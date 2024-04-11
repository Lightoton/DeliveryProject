package de.telran.deliveryproject.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Receiving user information by ID information.",
        description = "As a response, we receive data presented in JSON format and containing information" +
                "about the user. The object contains the first name, last name, phone number," +
                "email address, username (login) and password. In addition," +
                "the user has one role, with corresponding access to resources. ",
        responses = {
                @ApiResponse(responseCode = "200", description = "found"),
                @ApiResponse(responseCode = "404", description = "not found")
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        },
        hidden = false
)
public @interface GetUserInfoByIdMapping {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
