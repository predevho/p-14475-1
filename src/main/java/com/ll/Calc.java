package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[2]);

        if (expressionBits[1].equals("+")) {
            return num1 + num2;
        } else if (expressionBits[1].equals("-")) {
            return num1 - num2;
        } else {
            throw new RuntimeException("지원하지 않는 연산입니다.");
        }
    }
}
