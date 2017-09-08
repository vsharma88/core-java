package com.vips.shorties.ds;

import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 7/9/17
 **/
public class InfixToPostfixConversion {

    private static final String alphanumericRegex = "^[a-zA-Z0-9_]*$";
    private Stack<String> operatorStack = new Stack<>();

    public void evaluate(String infixExpression){
        System.out.print("\nInfix expression : "+infixExpression+"\n");
        System.out.print("\nPostfix expression :");

        String[] tokens = infixExpression.split(" ");
        for(String token : tokens) {
            if (token.trim().equalsIgnoreCase("(")) {
                operatorStack.push(token.trim());
            } else if (token.trim().equalsIgnoreCase(")")) {
                String itemPopped;
                while (!operatorStack.isEmpty()) {
                    itemPopped = operatorStack.pop();
                    if (!itemPopped.equalsIgnoreCase("(")) {
                        System.out.print(" " + itemPopped);
                    } else {
                        break;
                    }
                }
            } else if (token.matches(alphanumericRegex)){
                System.out.print(" "+token.trim());
            } else{
                int precedence = priority(token.trim());
                while(!operatorStack.isEmpty() && priority(operatorStack.peek()) >= precedence){
                    if(!operatorStack.peek().equalsIgnoreCase("("))
                        System.out.print(" "+operatorStack.pop());
                }
                operatorStack.push(token.trim());
            }
        }

        while (!operatorStack.isEmpty()){
            System.out.print(" "+operatorStack.pop());
        }
    }


    private int priority(String operator){
        int result = 0;
        switch ( operator) {
            case "+":
            case "-": result = 1;
                   break;

            case "*" :
            case "/" : result = 2;
                   break;
        }
        return result;
    }

    public static void main(String[] args) {
        InfixToPostfixConversion converter = new InfixToPostfixConversion();

        String infixExpression = " ( A + B - ( C + D ) * E ) ";
        converter.evaluate(infixExpression);
    }
}
