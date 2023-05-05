package org.sc.test;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void passingEmptyStringShouldReturnZero() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add("")).isZero();
    }

    @Test
    void testAddingTwoNumbers() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add("2,2")).isEqualTo(4);
    }

    @Test
    void testAddingTwoRandomNumbers() {
        Random random = new Random();
        int value1 = random.nextInt();
        int value2 = random.nextInt();
        Calculator calculator = new Calculator();
        assertThat(calculator.add(value1 + "," + value2)).isEqualTo(value1 + value2);
    }
}
