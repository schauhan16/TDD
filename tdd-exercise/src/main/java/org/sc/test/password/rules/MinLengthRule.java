package org.sc.test.password.rules;

import java.util.List;

public class MinLengthRule implements Rule {
    @Override
    public void apply(String passwordString, List<String> message) {
        if (passwordString.length() < 8) {
            message.add("Password must be at least 8 characters");
        }
    }
}
