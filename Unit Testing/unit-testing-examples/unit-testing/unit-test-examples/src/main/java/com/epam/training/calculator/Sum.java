package com.epam.training.calculator;

public class Sum {

    public Integer calculate(final String a, final String b) {
        Integer intA = parseInt(a);
        Integer intB = parseInt(b);
        return intA + intB;
    }

    private Integer parseInt(final String input) {
        validateNotNull(input);
        return doParseInt(input);
    }

    private Integer doParseInt(final String input) {
        Integer result = null;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Only int value is accepted!");
        }
        return result;
    }

    private void validateNotNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null parameter is illegal!");
        }
    }
}
