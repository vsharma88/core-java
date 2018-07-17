package com.vips.datastructure.stack.practice;


import com.vips.datastructure.stack.version02.LinkedListStack;
import com.vips.datastructure.stack.version02.Stack;

public class PalindromeTest {


    public static void main(String[] args) {
        String inputString01 = "I did , did I ?";
        String inputString02 = "Don't nod";
        String inputString03 = "Was it a car or cat I saw ?";
        String inputString04 = "abccba";
        String inputString05 = "Malayalam";

        System.out.println(isValidPalindrome(inputString01,new LinkedListStack<>()));
        System.out.println(isValidPalindrome(inputString02,new LinkedListStack<>()));
        System.out.println(isValidPalindrome(inputString03,new LinkedListStack<>()));
        System.out.println(isValidPalindrome(inputString04,new LinkedListStack<>()));
        System.out.println(isValidPalindrome(inputString05,new LinkedListStack<>()));
    }

    private static boolean isValidPalindrome(String inputString, Stack<String> stack){
        String[] inputToTest = inputString.split(" ");

        int tagger = 0;
        for(;tagger < inputToTest.length/2; tagger++){
            if(inputToTest[tagger].matches("[0-9A-Za-z']*")){
                stack.push(inputToTest[tagger]);
            }
        }

        while(tagger < inputToTest.length){
            if(!inputToTest[tagger].matches("[0-9A-Za-z']*")){
                tagger++;
                continue;
            }

          if(inputToTest[tagger++].equals(stack.peek())){
                stack.pop();
          }
        }

        if(stack.peek() == null){
            return true;
        }else{
            return false;
        }
    }


}
