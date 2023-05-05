package org.sc.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setup() {
        this.calculator = new StringCalculator();
    }

    @Test
    void emptyStringReturnZero() {
        Assertions.assertThat(calculator.add("")).isZero();
    }

    @Test
    void singleValueShouldReturnSameValue() {
        Assertions.assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    void shouldReturnTheSumOfTwoValues() {
        Assertions.assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void shouldReturnSumOfAllTheValues() {
        Assertions.assertThat(calculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    void shouldAllowNewLineAsSeparator() {
        Assertions.assertThat(calculator.add("1,2\n3")).isEqualTo(6);
    }

    @Test
    void shouldNotAllowTwoSeparatorsTogether() {
        Assertions.assertThat(calculator.add("1,\n3")).isZero();
    }
}
