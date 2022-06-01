package homework1;

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
}
