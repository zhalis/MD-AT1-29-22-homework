/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package homework1;

import static homework1.ScannerUtils.scanEnteredNumber;
import static homework1.ScannerUtils.scanEnteredOperation;

public class CalculatorMain {

    public static void main(String[] args) {
        do {
            System.out.println("Enter first number:");
            Double firstNumber = scanEnteredNumber();

            System.out.println("Enter operation +, -, *, /");
            MathOperation operation = scanEnteredOperation();

            System.out.println("Enter second number:");
            Double secondNumber = scanEnteredNumber();

            System.out.println(Calculator.calculateOperation(firstNumber, secondNumber, operation));
        } while (ScannerUtils.isContinue());
    }
}
