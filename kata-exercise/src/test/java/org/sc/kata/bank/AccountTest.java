package org.sc.kata.bank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void whenDepositShouldIncreaseAmount() {
        final Account account = new Account();
        account.deposit(100);
        account.printStatement();
        Assertions.assertThat(outputStreamCaptor.toString()).isEqualTo("""
                DATE       | AMOUNT  | BALANCE
                10/04/2014 | 100.00  | 100.00
                """);
    }
}
