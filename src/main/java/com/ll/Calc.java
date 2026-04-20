package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");
        //expressionBits 길이 만큼 숫자를 연산하는 곳에 대입하는 곳 필요
        //x + y - z =? 식이니까 2n만큼 숫자들이 배치
        int result = Integer.parseInt(expressionBits[0]);
        for(int i = 1; i < expressionBits.length; i = i + 2) {
            String bits = expressionBits[i];
            int nextNum = Integer.parseInt(expressionBits[i + 1]);
            if(bits.equals("+")) {
                result += nextNum;
            }
            else if(bits.equals("-")) {
                result -= nextNum;
            }
        }
        return result;
    }
}
