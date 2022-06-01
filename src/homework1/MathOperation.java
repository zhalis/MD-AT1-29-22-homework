package homework1;

import java.util.Arrays;
import java.util.Optional;

public enum MathOperation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String value;

    MathOperation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<MathOperation> valueOfOperation(String operation) {
       return Arrays.stream(values())
               .filter(mathOperation -> mathOperation.getValue().equals(operation))
               .findFirst();
    }
}
