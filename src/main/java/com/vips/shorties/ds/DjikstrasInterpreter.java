package com.vips.shorties.ds;

import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 5/9/17
 **/
public class DjikstrasInterpreter {

    private Stack<String> operator = new Stack<>();
    private Stack<Long> result = new Stack<>();


    private void expressionEvaluator(String expression){
        System.out.println("\nExpression is : "+expression);
        String[] expressionTokens = expression.split(" ");
        for (String tokens: expressionTokens) {
            if(tokens.equalsIgnoreCase("(")){
                //do nothing
            }else if(tokens.equalsIgnoreCase("+") || tokens.equalsIgnoreCase("*")){
                operator.push(tokens);
            }else if(tokens.equalsIgnoreCase(")")){
                String operation = operator.pop();
                if(operation.equalsIgnoreCase("+")){
                    Long value = result.pop() + result.pop();
                    result.push(value);
                }else if (operation.equalsIgnoreCase("*")){
                    Long value = result.pop() * result.pop();
                    result.push(value);
                }
            }else{
                result.push(Long.parseLong(tokens));
            }
        }

        System.out.println(" \nResult is  : "+ result.pop());
    }


    public static void main(String[] args) {
        DjikstrasInterpreter interpreter =  new DjikstrasInterpreter();
        interpreter.expressionEvaluator("( ( 2 + 1 ) * ( 3 + 5 ) )");

    }
}
