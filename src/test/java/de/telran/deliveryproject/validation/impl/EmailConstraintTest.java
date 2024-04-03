package de.telran.deliveryproject.validation.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EmailConstraintTest {
    private final EmailConstraint emailConstraint = new EmailConstraint();

    @ParameterizedTest
    @MethodSource("getEmails")
    void testEmailValidation(String email, boolean expected) {
        Assertions.assertEquals(expected, emailConstraint.isValid(email, null));
    }

    private static Stream<Arguments> getEmails() {
        return Stream.of(
                Arguments.of("john.doe@example.com", true),
                Arguments.of("alice_smith1234@example.co.uk", true),
                Arguments.of("user+test@example.net", true),
                Arguments.of("johfguidsjwdfhjiwefhujowefhuowefhiowefn.doe@.example.com", false),
                Arguments.of("alice_smith1234@example.", false),
                Arguments.of("alice_smith1234example.com", false),
                Arguments.of("", false)
        );
    }
}