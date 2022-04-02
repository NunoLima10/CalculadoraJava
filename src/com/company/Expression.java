package com.company;

import java.util.Stack;

public class Expression extends Throwable {

    public static String evaluate(String textResult) {

        textResult = textResult.strip();
        textResult += "_";
        char[] expression = textResult.toCharArray();

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        StringBuilder numbertext = new StringBuilder();

        double result;

        for (char c : expression) {

            if (Character.isAlphabetic(c)){throw new UnsupportedOperationException(": / Erro de Sintaxe");}

            if (Character.isDigit(c) && !(c == '_') || c == '.') {
                numbertext.append(c);
            } else {
                if (numbertext.length() !=0){
                    numbers.add(Double.parseDouble(numbertext.toString()));
                    numbertext = new StringBuilder();

                }

                if (c == '(') {
                    operations.push(c);
                } else if (c == ')') {
                    while (operations.peek() != '(') {
                        result = getResult(numbers.pop(), numbers.pop(), operations.pop());
                        numbers.push(result);
                        if (operations.isEmpty()){
                            throw new UnsupportedOperationException(": / Erro de Sintaxe");
                        }
                    }
                    operations.pop();
                } else if (!operations.isEmpty() && !(c == '_')) {
                    if (priorityOperation(operations.peek(), c)) {
                        result = getResult(numbers.pop(), numbers.pop(), c);
                        numbers.push(result);
                    } else {
                        operations.push(c);
                    }
                } else {
                    if (!Character.isDigit(c) && (!(c == '_'))) {
                        operations.push(c);
                    }
                }
            }
        }

        while (!operations.isEmpty()) {
            result = getResult(numbers.pop(), numbers.pop(), operations.pop());
            numbers.push(result);
        }

        return Double.toString(numbers.pop());
    }

    private static double getResult(double number1, double number2, char operation) {
        switch (operation) {
            case '+':
                return number2 + number1;
            case '-':
                return number2 - number1;
            case '/':
                if (number1 == 0) throw new UnsupportedOperationException(": / Divisão por 0 ");
                return number2 / number1;
            case '*':
                return number2 * number1;
            case '%':
                return number2 % number1;
            case '^':
                return Math.pow(number2, number1);
        }
        return 0;
    }

    public static boolean priorityOperation(char operation, char nextOperation) {
        if (operation == '(' || nextOperation == ')') return false;
        String priority = "^*/%+-";
        int indexOperation = priority.indexOf(operation);
        int indexNextOperation = priority.indexOf(nextOperation);
        return indexOperation <= indexNextOperation;
    }

    public static boolean Valid(char number) {
        char[] validNumbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < validNumbers.length; i++) {
            if (validNumbers[i] == number) {

            }

        }
        return true;
    }



}
