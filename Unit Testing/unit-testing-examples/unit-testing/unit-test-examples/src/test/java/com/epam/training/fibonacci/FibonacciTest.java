package com.epam.training.fibonacci;

import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    void testBase() {
        long actual = Fibonacci.fibonacci(0);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void testSimple() {
        Assertions.assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void testNegative() {
        new Date();
        LocalDate.now();
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(0)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(1)));
    }

    @AfterEach
    void doCleanup() {

    }
}
