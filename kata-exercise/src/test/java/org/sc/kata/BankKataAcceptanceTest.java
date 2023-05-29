package org.sc.kata;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sc.kata.bank.Account;

public class BankKataAcceptanceTest {

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
    void printStatementShouldPrint() {
        final Account account = new Account();
        account.printStatement();
        Assertions.assertThat(outputStreamCaptor.toString().trim())
        .isEqualTo(
                """
                DATE       | AMOUNT  | BALANCE
                10/04/2014 | 500.00  | 1400.00
                02/04/2014 | -100.00 | 900.00
                01/04/2014 | 1000.00 | 1000.00
                """.trim());
    }
}
