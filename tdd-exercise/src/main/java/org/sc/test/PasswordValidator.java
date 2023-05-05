package org.sc.test;

import org.sc.test.password.rules.*;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private final List<Rule> rules = List.of(
            new MinLengthRule(),
            new TwoDigitRule(),
            new CapitalLetterRule(),
            new SpecialCharacterRule());

    public Result validate(String passwordString) {
        final List<String> message = new ArrayList<>();
        rules.forEach(rule -> rule.apply(passwordString, message));
        if (!message.isEmpty()) {
            return new Result(false, String.join(";", message));
        }
        return new Result(true, "Password is strong!!!");
    }

    public record Result(Boolean isValid, String message) {
    }
}
