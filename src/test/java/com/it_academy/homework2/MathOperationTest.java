package com.it_academy.homework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static com.it_academy.homework1.MathOperation.ADD;
import static com.it_academy.homework1.MathOperation.DIVIDE;
import static com.it_academy.homework1.MathOperation.MULTIPLY;
import static com.it_academy.homework1.MathOperation.SUBTRACT;
import static com.it_academy.homework1.MathOperation.valueOfOperation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
class MathOperationTest {

    @Test
    public void getAddMathOperationByValueTest() {
        assertEquals(Optional.of(ADD), valueOfOperation("+"), "Operation is incorrect");
    }

    @Test
    public void getSubtractMathOperationByValueTest() {
        assertEquals(Optional.of(SUBTRACT), valueOfOperation("-"), "Operation is incorrect");
    }

    @Test
    public void getMultiplyMathOperationByValueTest() {
        assertEquals(Optional.of(MULTIPLY), valueOfOperation("*"), "Operation is incorrect");
    }

    @Test
    public void getDivideMathOperationByValueTest() {
        assertEquals(Optional.of(DIVIDE), valueOfOperation("/"), "Operation is incorrect");
    }

    @ParameterizedTest
    @ValueSource(strings = {"23", "sdf", "-*+/", "_", "- * "})
    public void isEmptyOptionalByValueTest(String value) {
        assertTrue(valueOfOperation(value).isEmpty(), "Optional is not empty");
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "/", "-", "+"})
    public void isNotEmptyOptionalByValueTest(String value) {
        assertFalse(valueOfOperation(value).isEmpty(), "Optional is empty");
    }
}