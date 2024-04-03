package de.telran.deliveryproject.validation.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UuidConstraintTest {
    private final UuidConstraint uuidConstraint = new UuidConstraint();
    @ParameterizedTest
    @MethodSource("getUUIDs")
    void testUUIDValidation(String UUID, boolean expected) {
        assertEquals(expected, uuidConstraint.isValid(UUID, null));
    }
    private static Stream<Arguments> getUUIDs(){
        return Stream.of(
                Arguments.of("550e8400-e29b-41d4-a716-446655440000",true),
                Arguments.of("7f6e93bd-cc12-4e77-9644-c3c8ff60d13a",true),
                Arguments.of("",false),
                Arguments.of("abcdefg-hijklmno-pqrstuvw-xyzabcd-efghijkl", false),
                Arguments.of("550e8400-e29b-41d4-a716-44665544z000",false)
        );
    }
}