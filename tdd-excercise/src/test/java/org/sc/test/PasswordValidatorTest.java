package org.sc.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setup() {
        this.passwordValidator = new PasswordValidator();
    }

    @ParameterizedTest
    @MethodSource("data")
    void validatePassword(String testPasswordString,
                          boolean expectedValidationResult,
                          String expectedMessage) {
        final PasswordValidator.Result validationResult = passwordValidator.validate(testPasswordString);
        assertThat(validationResult.isValid()).isEqualTo(expectedValidationResult);
        assertThat(validationResult.message()).isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                passwordMustHave8Characters(),
                passwordMustHave2Digits(),
                passwordMustHave8CharactersIncluding2Digits(),
                passwordMustHaveOneCapitalLetter(),
                passwordMustHaveSpecialCharacter(),
                passwordIsStrong()
        );
    }

    private static Arguments passwordMustHave8Characters() {
        return Arguments.of("12qW@rt", false, "Password must be at least 8 characters");
    }

    private static Arguments passwordMustHave2Digits() {
        return Arguments.of("a@cDefgh", false, "The password must contain at least 2 numbers");
    }

    private static Arguments passwordMustHave8CharactersIncluding2Digits() {
        return Arguments.of("qw@rTyu", false, "Password must be at least 8 characters;The password must contain at least 2 numbers");
    }

    private static Arguments passwordMustHaveOneCapitalLetter() {
        return Arguments.of("12$werty", false, "Password must contain at least one capital letter");
    }

    private static Arguments passwordMustHaveSpecialCharacter() {
        return Arguments.of("12Qwerty", false, "Password must contain at least one special character");
    }

    private static Arguments passwordIsStrong() {
        return Arguments.of("Qwerty@123", true, "Password is strong!!!");
    }
}
