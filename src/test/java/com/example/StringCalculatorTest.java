package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName(" Return 0 på tom sträng")
    void methodAddTest(){

        StringCalculator calculator = new StringCalculator();
        String numbers = "";
        int actual = 0;
        int expected = 0;
        actual = calculator.add(numbers);

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName(" Return number from String")
    void TestSendStringOneNumber(){

        StringCalculator calculator = new StringCalculator();

        String numbers = "1";
        int actual = 0;
        int expected = 1;
        actual = calculator.add(numbers);

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName(" Send in two numbers ")
    void TestAddTwoNumbers(){

        StringCalculator calculator = new StringCalculator();

        String numbers = "1,2";
        int actual = 0;
        int expected = 3;
        actual = calculator.add(numbers);

        assertEquals(expected, actual);
    }

}