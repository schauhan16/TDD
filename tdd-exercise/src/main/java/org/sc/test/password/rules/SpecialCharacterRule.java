package org.sc.test.password.rules;

import java.util.List;

public class SpecialCharacterRule implements Rule {
    @Override
    public void apply(String string, List<String> message) {
        if (!stringHasSpecialChar(string)) {
            message.add("Password must contain at least one special character");
        }
    }

    private boolean stringHasSpecialChar(String passwordString) {
        return passwordString.chars()
                .anyMatch(c -> !Character.isLetter(c)
                        && !Character.isDigit(c)
                        && !Character.isSpaceChar(c));
    }
}
