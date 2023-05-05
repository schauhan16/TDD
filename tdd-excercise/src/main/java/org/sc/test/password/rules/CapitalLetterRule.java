package org.sc.test.password.rules;

import java.util.List;

public class CapitalLetterRule implements Rule {
    @Override
    public void apply(String string, List<String> message) {
        if (!stringHasCapitalLetter(string)) {
            message.add("Password must contain at least one capital letter");
        }
    }

    private boolean stringHasCapitalLetter(String passwordString) {
        return passwordString.chars()
                .anyMatch(c -> Character.isLetter(c) && Character.isUpperCase(c));
    }
}
