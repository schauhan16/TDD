package org.sc.test.password.rules;

import java.util.List;

public class TwoDigitRule implements Rule {
    @Override
    public void apply(String passwordString, List<String> message) {
        if (!stringHasTwoNumbers(passwordString)) {
            message.add("The password must contain at least 2 numbers");
        }
    }


    private boolean stringHasTwoNumbers(String passwordString) {
        int count = 0;
        for (char c : passwordString.toCharArray()) {
            if (Character.isDigit(c))
                count++;

            if (count == 2) {
                return true;
            }
        }
        return false;
    }

}
