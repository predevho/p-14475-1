package com.ll;

//expressionBits 길이 만큼 숫자를 연산하는 곳에 대입하는 곳 필요
//x + y - z =? 식이니까 2n만큼 숫자들이 배치

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//사칙연산 우선순위 곱셈부터 시작해야함
public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");
        List<String> bitsList = new ArrayList<>(Arrays.asList(expressionBits));

        if (expression.contains("(")) {
            int open = expression.lastIndexOf('(');
            int close = expression.indexOf(')', open);
            String inner = expression.substring(open + 1, close);

            int innerResult = run(inner);
            expression = expression.substring(0, open) + innerResult + expression.substring(close + 1);

            return run(expression);
        }


        int i = 1;
        while(i < bitsList.size()) {
            String bitString = bitsList.get(i);
            if(bitString.equals("*")) {
                int left = Integer.parseInt(bitsList.get(i-1));
                int right = Integer.parseInt(bitsList.get(i+1));
                int result = left * right;
                bitsList.set(i-1, String.valueOf(result));
                bitsList.remove(i); // 연산자 제거
                bitsList.remove(i); // 오른쪽 숫자 제거
            }else {
                i += 2; // 다음 연산자로 이동
            }
        }


        int result = Integer.parseInt(bitsList.get(0));
        for(int j = 1; j < bitsList.size(); j += 2) {
            String bits = bitsList.get(j);
            int nextNum = Integer.parseInt(bitsList.get(j+1));
            switch (bits) {
                case "+" -> result += nextNum;
                case "-" -> result -= nextNum;
            }
        }
        return result;
    }
}
