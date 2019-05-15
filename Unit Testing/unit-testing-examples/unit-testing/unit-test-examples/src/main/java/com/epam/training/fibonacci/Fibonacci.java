package com.epam.training.fibonacci;

public class Fibonacci {

     static long fibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Positive indices only");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
