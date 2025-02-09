class Calculator {
    static double add(double a, double b) {
        return a + b
    }

    static double subtract(double a, double b) {
        return a - b
    }

    static double multiply(double a, double b) {
        return a * b
    }

    static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.")
        }
        return a / b
    }
}