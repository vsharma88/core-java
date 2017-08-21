package com.vips.datastructure.stack;

import java.util.Stack;

/**
 * @author Vipin Sharma
 * @category <blockquote>Interview Questions</blockquote>
 *
 * Problem Description : Check whether the string is palindrome or not
 *   i/p : malayalam,office
 *   o/p : true,false
 *
 */

public class PalindromeCheck {

    public void checkPalindrome(String inputString){
        Stack<Character> tempStack = new Stack<Character>();
        StringBuilder builder = new StringBuilder();
        for(Character character : inputString.toCharArray()){
            tempStack.push(character);
        }

        while(!tempStack.isEmpty()){
            builder.append(tempStack.pop());
        }

        if(inputString.equalsIgnoreCase(builder.toString()))
            System.out.println(inputString+" : "+true);
        else
            System.out.print(inputString+" : "+false);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String inputStringOne = "Malayalam";
        String inputStringTwo = "Office";

        PalindromeCheck palindromeCheck = new PalindromeCheck();
        palindromeCheck.checkPalindrome(inputStringOne);
        palindromeCheck.checkPalindrome(inputStringTwo);
    }

}