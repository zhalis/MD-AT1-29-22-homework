package com.it_academy.homework2;

import com.it_academy.homework1.error.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.it_academy.homework1.Calculator.calculateOperation;
import static com.it_academy.homework1.MathOperation.ADD;
import static com.it_academy.homework1.MathOperation.DIVIDE;
import static com.it_academy.homework1.MathOperation.MULTIPLY;
import static com.it_academy.homework1.MathOperation.SUBTRACT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Execution(ExecutionMode.CONCURRENT)
class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1.45, -5.45, -4.0", "-3.5, -7, -10.5", "3.45, 5, 8.45"})
    public void addTest(double firstNumber, double secondNumber, double result) {
        assertEquals(result,
                calculateOperation(firstNumber, secondNumber, ADD),
                "The result of addition is incorrect");
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 2, 1.0", "-3.5, -7, 3.5", "-3.5, 5.5, -9.0", "5, -5, 10.0"})
    public void subtractTest(double firstNumber, double secondNumber, double result) {
        assertEquals(result,
                calculateOperation(firstNumber, secondNumber, SUBTRACT),
                "The result of subtraction is incorrect");
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 2, 6.0", "-3.5, -2, 7.0", "-3.5, 4, -14.0", "4, 0, 0"})
    public void multiplyTest(double firstNumber, double secondNumber, double result) {
        assertEquals(result,
                calculateOperation(firstNumber, secondNumber, MULTIPLY),
                "The result of multiplication is incorrect");
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 2, 1.5", "-2.4, -2.0, 1.2", "-8, 4, -2.0"})
    public void divideTest(double firstNumber, double secondNumber, double result) {
        assertEquals(result,
                calculateOperation(firstNumber, secondNumber, DIVIDE),
                "The result of division is incorrect");
    }

    @Test
    public void divideByZeroTest() {
        DivisionByZeroException actualException = assertThrows(DivisionByZeroException.class,
                () -> calculateOperation(3, 0, DIVIDE), "The result of division is incorrect");
        assertEquals("Divider cannot be 0", actualException.getMessage(), "Message is incorrect");
    }
}