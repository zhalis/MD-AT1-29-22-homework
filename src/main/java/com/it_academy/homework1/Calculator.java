package com.it_academy.homework1;

import com.it_academy.homework1.error.DivisionByZeroException;

import static java.lang.String.format;

public class Calculator {

    /**
     * The method calculates the result of selected operation between 2 numbers
     *
     * @param firstNumber  first number
     * @param secondNumber second number
     * @param operation    operation
     * @return the result of mathematical operation
     */
    public static double calculateOperation(double firstNumber, double secondNumber, MathOperation operation) {
        return switch (operation) {
            case ADD -> add(firstNumber, secondNumber);
            case DIVIDE -> divide(firstNumber, secondNumber);
            case MULTIPLY -> multiply(firstNumber, secondNumber);
            case SUBTRACT -> subtract(firstNumber, secondNumber);
            default -> throw new IllegalArgumentException(format("Operation %s is not supported", operation.name()));
        };
    }

    /**
     * The method produces addition
     *
     * @param firstTern  first tern
     * @param secondTern second tern
     * @return addition result
     */
    private static double add(double firstTern, double secondTern) {
        return firstTern + secondTern;
    }

    /**
     * The method produces subtraction
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return subtraction result
     */
    private static double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    /**
     * The method produces multiplication
     *
     * @param firstMultiplier  first multiplier
     * @param secondMultiplier second multiplier
     * @return multiplication result
     */
    private static double multiply(double firstMultiplier, double secondMultiplier) {
        return firstMultiplier * secondMultiplier;
    }

    /**
     * The method produces division
     *
     * @param dividend dividend
     * @param divider  divider
     * @return division result
     * @throws DivisionByZeroException – if divider == 0
     */
    private static double divide(double dividend, double divider) {
        if (divider == 0) {
            throw new DivisionByZeroException("Divider cannot be 0");
        }
        return dividend / divider;
    }
}
