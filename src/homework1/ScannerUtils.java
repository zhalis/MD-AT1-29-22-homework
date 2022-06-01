/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package homework1;

import java.util.Optional;
import java.util.Scanner;

public class ScannerUtils {

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
