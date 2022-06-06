package homework1;

import static homework1.ScannerUtils.scanEnteredNumber;
import static homework1.ScannerUtils.scanEnteredOperation;

public class CalculatorMain {

    public static void main(String[] args) {
        do {
            System.out.println("Enter first number:");
            double firstNumber = scanEnteredNumber();

            System.out.println("Enter operation +, -, *, /");
            MathOperation operation = scanEnteredOperation();

            System.out.println("Enter second number:");
            double secondNumber = scanEnteredNumber();

            System.out.println(Calculator.calculateOperation(firstNumber, secondNumber, operation));
        } while (ScannerUtils.isContinue());
    }
}
