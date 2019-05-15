package com.epam.training.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorTest {
    //Positive
    //1. one number
    //2. multiple numbers
    //4. overlapping separator with numbers formatting
    //5. multi-char separator

    //Negative
    //1. null
    //2. empty

    @Test
    void oneNumberMock() {
        //Arrange
        String input = "5";
        String separator = "|";
        Sum sum = Mockito.mock(Sum.class);
        Mockito.when(sum.calculate(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Integer.parseInt(input));

        Calculator calc = new Calculator();
        calc.setLog(Mockito.mock(Logger.class));
        calc.setSum(sum);

        //Act
        long actual = calc.sum(input, separator);

        //Assert
        Assertions.assertEquals(5, actual);
    }

    @Test
    void oneNumberStub() {
        //Arrange
        String input = "5";
        String separator = "|";

        Sum sum = new Sum() {

            public Integer calculate(String a, String b) {
                return Integer.parseInt(input);
            }
        };

        Logger logger = new Logger() {
            @Override
            public void logInfo(String msg) {
                //do nothing
            }
        };

        Calculator calc = new Calculator();
        calc.setLog(logger);
        calc.setSum(sum);

        //Act
        long actual = calc.sum(input, separator);

        //Assert
        Assertions.assertEquals(5, actual);
    }
}
