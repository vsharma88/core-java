package com.vips.datastructure.stack.practice;

import com.vips.datastructure.stack.version02.ArrayStack;
import com.vips.datastructure.stack.version02.LinkedListStack;
import com.vips.datastructure.stack.version02.Stack;

public class InfixPostfixConverter {

    public static void main(String[] args) {
        String expression01 = "a+b*(c/d-e)/(f+g*h)-i";
        String expression02 = "A+B-C+(X+L)";
        ArrayStack<String> linkedListStack = new ArrayStack<>(20);
        System.out.println(converter(expression01,linkedListStack));
        System.out.println(converter(expression02,linkedListStack));
    }

    private static String converter(String expression, Stack<String> operatorStack) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < expression.length()) {
            String token = String.valueOf(expression.charAt(i));
            i++;
            if (token.matches("[0-9a-zA-Z]*")) {
                stringBuilder.append(token);
            } else {

                switch (token) {
                    case "+":
                        while(operatorStack.peek() != null &&
                        operatorStack.peek().matches("[-+/*]")){
                            stringBuilder.append(operatorStack.pop());
                        }
                        operatorStack.push("+");
                        break;
                    case "-":
                        while(operatorStack.peek() != null &&
                                operatorStack.peek().matches("[-+/*]")){
                            stringBuilder.append(operatorStack.pop());
                        }
                        operatorStack.push("-");
                        break;
                    case "*":
                        while(operatorStack.peek() != null &&
                                operatorStack.peek().matches("[/*]")){
                            stringBuilder.append(operatorStack.pop());
                        }
                        operatorStack.push("*");
                        break;
                    case "/":
                        while(operatorStack.peek() != null &&
                                operatorStack.peek().matches("[/*]")){
                            stringBuilder.append(operatorStack.pop());
                        }
                        operatorStack.push("/");
                        break;
                    case "(":
                        operatorStack.push("(");
                        break;

                    case ")":
                        while(operatorStack.peek() != null &&
                                !operatorStack.peek().equals("("))
                            stringBuilder.append(operatorStack.pop());

                        operatorStack.pop();
                        break;
                }
                }
        }
        while(operatorStack.peek()!= null){
            stringBuilder.append(operatorStack.pop());
        }

        return stringBuilder.toString();
        }
    }