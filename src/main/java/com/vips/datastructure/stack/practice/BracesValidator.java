package com.vips.datastructure.stack.practice;

import com.vips.datastructure.stack.version02.LinkedListStack;
import com.vips.datastructure.stack.version02.Stack;

public class BracesValidator {

    public static void main(String[] args) {
        String testerString = "{dasdasdasd{dsad(dsad)}]}";
        LinkedListStack<String> dasa = new LinkedListStack<>();
        System.out.println(validateExpression(testerString,dasa ));
    }

    private static boolean validateExpression(String expression, Stack<String> stringStack){

        int i = 0;
        while(i < expression.length()){
            String token = String.valueOf(expression.charAt(i));
            if(token.matches("[0-9a-zA-Z]*")){
                //do nothing
            }else{
                if(token.matches("[{\\[\\(]")){
                    stringStack.push(token);
                }else{
                    switch (token){
                        case "}":
                            if(!stringStack.peek().equals("{")){
                                return false;
                            }
                            stringStack.pop();
                            break;
                        case ")":
                            if(!stringStack.peek().equals("(")){
                                return false;
                            }
                            stringStack.pop();
                            break;
                        case "]":
                            if (!stringStack.peek().equals("[")){
                                return false;
                            }
                            stringStack.pop();
                            break;
                    }
                }
            }
           i++;
        }
        return true;
    }

}
