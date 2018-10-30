package com.vips.learning.java.datastructure.stack.practice;

import com.vips.learning.java.datastructure.stack.version02.ArrayStack;
import com.vips.learning.java.datastructure.stack.version02.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
    Stack<Integer> integerStack = new ArrayStack<>(100);
    String expression = "123*+";
    evaluateExpression(expression, integerStack);
    }

    private static int evaluateExpression(String expression, Stack<Integer> operandStack){
       int iterator = 0;
        while (iterator < expression.length()){
            String token = String.valueOf(expression.charAt(iterator));
            if(token.matches("[+/-/*]")){
                switch (token){
                    case "+":
                        operandStack.push(operandStack.pop()+operandStack.pop());
                        break;
                    case "-":
                        operandStack.push(operandStack.pop()-operandStack.pop());
                        break;
                    case "*":
                        operandStack.push(operandStack.pop()*operandStack.pop());
                        break;
                    case "/":
                        operandStack.push(operandStack.pop()/operandStack.pop());
                        break;
                }
            }else{
                operandStack.push(Integer.parseInt(token));
            }
            iterator++;
        }

        System.out.println(
                operandStack.pop()
        );

        return 0;
    }

}
