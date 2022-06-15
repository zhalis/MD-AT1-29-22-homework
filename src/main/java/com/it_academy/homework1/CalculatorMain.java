package com.it_academy.homework1;

import static com.it_academy.homework1.MathOperation.DIVIDE;
import static com.it_academy.homework1.ScannerUtils.scanEnteredNumber;
import static com.it_academy.homework1.ScannerUtils.scanEnteredOperation;

public class CalculatorMain {

    public static void main(String[] args) {
        do {
            System.out.println("Enter first number:");
            double firstNumber = scanEnteredNumber();

            System.out.println("Enter operation +, -, *, /");
            MathOperation operation = scanEnteredOperation();

            System.out.println("Enter second number:");
            double secondNumber = scanEnteredNumber();

            while (DIVIDE.equals(operation) && secondNumber == 0) {
                System.out.println("Division by zero is prohibited. Try entering second number again:");
                secondNumber = scanEnteredNumber();
            }
            System.out.println("Result: " + Calculator.calculateOperation(firstNumber, secondNumber, operation));
        } while (ScannerUtils.isContinue());
    }
}
