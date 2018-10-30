package com.vips.learning.java.shorties.ds;

import java.util.Stack;

public class PostfixExpressionEvaluation {

    private static final String alphanumericRegex = "^[a-zA-Z0-9_]*$";
    private Stack<Integer> operandStack = new Stack<>();


    public void evaluateExpression(String postfixExpression){
        System.out.println("\nPostfix Expression : "+postfixExpression);

        String [] tokens = postfixExpression.split(" ");

        for(String token : tokens){
            if(token.matches(alphanumericRegex)){
                operandStack.push(Integer.parseInt(token.trim()));
            }else{
                Integer poppedItem = operandStack.pop();
                if(token.equalsIgnoreCase("++") || token.equalsIgnoreCase("--")){
                    operandStack.push((poppedItem++));
                }else{
                    Integer result = new Integer(0);
                    switch (token){
                        case "+" : result = poppedItem + operandStack.pop();
                              break;
                        case "-" :  result = poppedItem - operandStack.pop();
                              break;
                        case "*" : result = poppedItem * operandStack.pop();
                              break;
                        case "/" : result = poppedItem /  operandStack.pop();
                            break;
                    }
                    operandStack.push(result);
                }
            }
        }

        System.out.println("\nResult is : "+operandStack.pop());
    }

    public static void main(String[] args) {
        PostfixExpressionEvaluation expressionEvaluation = new PostfixExpressionEvaluation();

        String postfixExpression = "2 3 + 3 5 * -";
        expressionEvaluation.evaluateExpression(postfixExpression);
    }
}
