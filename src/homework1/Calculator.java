/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package homework1;

import java.util.Scanner;

public class Calculator {

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
     */
    private static double divide(double dividend, double divider) {
        while (divider == 0) {
            System.out.println("Divider cannot be 0, please enter other number:");
            divider = scanEnteredNumber();
        }
        return dividend / divider;
    }

    /**
     * The method checks the correctness of the data and returns from
     *
     * @return return correct data
     */
    private static double scanEnteredNumber() {
        Scanner scanner = new Scanner(System.in);
        Double number = null;
        while (number == null) {
            System.out.println("enter number:");
            try {
                number = Double.parseDouble(scanner.next());
            } catch (NumberFormatException exception) {
                System.out.println("entered incorrect number! Try again");
            }
        }
        return number;
    }

    /**
     * The method calculates for the selected operation
     *
     * @return the result of mathematical operation
     */
    public static double calculateOperation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("enter operation +, -, *, /");
            String operation = scanner.next();
            if (MathOperation.ADD.getValue().equals(operation)) {
                return add(scanEnteredNumber(), scanEnteredNumber());
            } else if (MathOperation.SUBTRACT.getValue().equals(operation)) {
                return subtract(scanEnteredNumber(), scanEnteredNumber());
            } else if (MathOperation.MULTIPLY.getValue().equals(operation)) {
                return multiply(scanEnteredNumber(), scanEnteredNumber());
            } else if (MathOperation.DIVIDE.getValue().equals(operation)) {
                return divide(scanEnteredNumber(), scanEnteredNumber());
            } else {
                System.out.println("entered incorrect operation! Try again");
            }
        }
    }

    /**
     * The method includes a calculator
     *
     * @return true or false
     */
    public static boolean isTurnOffCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to continue? \n if YES - enter yes, if NO - enter no");
            String offOrContinue = scanner.next();
            if (offOrContinue.equalsIgnoreCase("yes")) {
                return true;
            } else if (offOrContinue.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("entered incorrect data! Try again");
            }
        }
    }
}
