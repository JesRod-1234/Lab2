package com.example;

public class StringCalculator {

    int add( String numbers){
        if (numbers.isBlank())
        return 0;
        else {
            String[] numbersArray = null;
            int sumOfNumbers = 0;
            numbersArray = numbers.split("[\n,]");

            for (var numberarray: numbersArray) {
                sumOfNumbers += Integer.parseInt(numberarray);

            }
            return sumOfNumbers;
        }

    }

}
