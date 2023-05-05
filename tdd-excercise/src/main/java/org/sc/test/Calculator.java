package org.sc.test;

import java.util.Arrays;

public class Calculator {

    public int add(String commaSeparatedString) {
        if (commaSeparatedString.isBlank()) {
            return 0;
        }
        return Arrays.stream(commaSeparatedString.split(","))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
