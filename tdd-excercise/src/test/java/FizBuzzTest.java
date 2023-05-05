import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void testFizzForMultipleOf3() {
        assertThat(fizzBuzz.get(3)).isEqualTo("Fizz");
    }

    @Test
    void testShouldNotReturnFizzForNotMultipleOf3() {
        assertThat(fizzBuzz.get(1)).isNotEqualTo("Fizz");
    }

    @Test
    void testShouldReturnBuzzOnMultipleOf5() {
        assertThat(fizzBuzz.get(5)).isEqualTo("Buzz");
    }

    @Test
    void testShouldNotReturnBuzzOnMultipleOfNot5() {
        assertThat(fizzBuzz.get(1)).isNotEqualTo("Buzz");
    }

    @Test
    void testShouldReturnFizzBuzzOnMultipleOf3And5() {
        assertThat(fizzBuzz.get(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void testShouldReturnNumberIfNotAMultipleOf3Or5() {
        assertThat(fizzBuzz.get(17)).isEqualTo("17");
    }
}
