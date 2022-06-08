package com.it_academy.homework1;

import java.util.Optional;
import java.util.Scanner;

public final class ScannerUtils {

    private ScannerUtils() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * The method checks the correctness of entered number
     *
     * @return return number
     */
    public static double scanEnteredNumber() {
        Double number = null;
        while (number == null) {
            try {
                number = Double.parseDouble(SCANNER.next());
            } catch (NumberFormatException exception) {
                System.out.println("Entered incorrect number! Try again:");
            }
        }
        return number;
    }

    /**
     * The method checks the correctness of entered operation
     *
     * @return return correct operation
     */
    public static MathOperation scanEnteredOperation() {
        Optional<MathOperation> operation = Optional.empty();

        while (operation.isEmpty()) {
            operation = MathOperation.valueOfOperation(SCANNER.next());
            if (operation.isEmpty()) {
                System.out.println("Entered incorrect operation! Available operations: +, -, *, /. Try again:");
            }
        }
        return operation.get();
    }

    /**
     * This method requests true or false from console to continue processing
     *
     * @return true or false
     */
    public static boolean isContinue() {
        while (true) {
            System.out.println("Do you want to continue? \n if YES - enter Y, if NO - enter N");
            String offOrContinue = SCANNER.next();
            if (offOrContinue.equalsIgnoreCase("y")) {
                return true;
            } else if (offOrContinue.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Entered incorrect data! Try again:");
            }
        }
    }
}
