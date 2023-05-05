package org.sc.test;

import java.util.Arrays;

public class StringCalculator {
    public int add(String values) {
        if ("".equals(values)) {
            return 0;

        }

        return Arrays.stream(values.split(","))
                .flatMap(v -> Arrays.stream(v.split("\n")))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
