package com.vips.shorties.ds;

import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 7/9/17
 **/
public class InfixToPostfixConversion {

    private Stack<String> operatorStack = new Stack<>();


    public void convertExpression(String infixExpression){
        System.out.print("\nInfix expression : "+infixExpression+"\n");

        String[] tokens = infixExpression.split(" ");
        for(String token : tokens){
            if(token.trim().equalsIgnoreCase("(")){
                operatorStack.push(token.trim());
            }else if(token.trim().equalsIgnoreCase(")")){
                String itemPopped = operatorStack.pop();
                while(!operatorStack.isEmpty() && !itemPopped.equalsIgnoreCase("(")){
                    System.out.print(" "+operatorStack.pop());
                }
            } else if(token.trim().equalsIgnoreCase("+") || token.trim().equalsIgnoreCase("-") || token.trim().equalsIgnoreCase("*") || token.trim().equalsIgnoreCase("/")){
                    if(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-")){
                        String poppedItem = operatorStack.pop();
                        while(!operatorStack.isEmpty() && !poppedItem.equalsIgnoreCase("(")){
                            System.out.print(" "+operatorStack.pop());
                        }
                        operatorStack.push(token);
                    }else{
                        String itemPopped = operatorStack.pop();
                        while(!operatorStack.isEmpty() && (itemPopped.equalsIgnoreCase("(") || itemPopped.equalsIgnoreCase("+") || itemPopped.equalsIgnoreCase("-"))){
                            System.out.print(" "+operatorStack.pop());
                        }
                        operatorStack.push(token);
                    }


            } else{
                System.out.print(" "+token);
            }
        }

        while (!operatorStack.isEmpty()) {
          String itemPopped = operatorStack.pop();
            if(!itemPopped.equalsIgnoreCase("("))
            System.out.print(" " + operatorStack.pop());
        }

    }



    public void evaluateExpression(String infixExpression){
        System.out.print("\nInfix expression : "+infixExpression+"\n");
        System.out.print("\nPostfix expression : \n");

        String[] tokens = infixExpression.split(" ");
        for(String token : tokens){

            if(token.trim().equalsIgnoreCase("(")){
                operatorStack.push(token.trim());
            } else if (token.trim().equalsIgnoreCase(")")){
                while(!operatorStack.isEmpty()){
                    String itemPopped = operatorStack.pop();
                    if(!itemPopped.equalsIgnoreCase("(")){
                        System.out.print(" "+itemPopped);
                    }else{
                        break;

                    }
                }
            } else if (token.trim().equalsIgnoreCase("+") ||token.trim().equalsIgnoreCase("-")){
               if(operatorStack.isEmpty()){
                   operatorStack.push(token.trim());
               }else{
                   String itemPopped;
                   while(!operatorStack.isEmpty()){
                       itemPopped = operatorStack.peek();
                       if(itemPopped.equalsIgnoreCase("(")){
                          break;
                       }

                       System.out.print(" "+itemPopped);
                       itemPopped = operatorStack.pop();

                   }
                   operatorStack.push(token.trim());
               }

            }else if (token.trim().equalsIgnoreCase("*") ||token.trim().equalsIgnoreCase("/")){
                String itemPopped;
                while(!operatorStack.isEmpty()){
                   itemPopped = operatorStack.peek();
                   if(!itemPopped.equalsIgnoreCase("*") ||!itemPopped.equalsIgnoreCase("/") || itemPopped.equalsIgnoreCase("(")){
                       operatorStack.push(token);
                       break;
                   }
                    System.out.print(" "+itemPopped);
                   itemPopped = operatorStack.pop();
                }

            } else{
                System.out.print(" "+token);
            }

        }
    }



    public static void main(String[] args) {
        InfixToPostfixConversion converter = new InfixToPostfixConversion();

        String infixExpression = " A + B - ( C + D ) * E ";
        converter.evaluateExpression(infixExpression);
    }
}
