package homework1;

import static homework1.ScannerUtils.scanEnteredNumber;
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
        switch (operation) {
            case ADD:
                return add(firstNumber, secondNumber);
            case DIVIDE:
                return divide(firstNumber, secondNumber);
            case MULTIPLY:
                return multiply(firstNumber, secondNumber);
            case SUBTRACT:
                return subtract(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException(format("Operation %s is not supported", operation.name()));
        }
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
     */
    private static double divide(double dividend, double divider) {
        while (divider == 0) {
            System.out.println("Divider cannot be 0, please enter other number:");
            divider = scanEnteredNumber();
        }
        return dividend / divider;
    }
}
