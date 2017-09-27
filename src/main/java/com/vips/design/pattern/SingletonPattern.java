package com.vips.design.pattern;

/**
 * @author Vipin Sharma
 * @category <blockquote>Design Pattern</blockquote>
 * @DATE 20/09/17
 **/

public class SingletonPattern {

    private static SingletonPattern singletonPatternInstance;
//  private static SingletonPattern singletonPatternInstance = new SingletonPattern();   Eager initialization

    private SingletonPattern(){ }//making constructor private

    //lazy initialization
    public static SingletonPattern getSingletonPatternInstance(){
        if(singletonPatternInstance == null){
            synchronized (SingletonPattern.class){
                if(singletonPatternInstance == null){
                    singletonPatternInstance = new SingletonPattern();
                }
            }
        }
        return singletonPatternInstance;
    }

    public static void main(String[] args) {
        SingletonPattern singletonPatternInstance_01 = SingletonPattern.getSingletonPatternInstance();
        SingletonPattern singletonPatternInstance_02 = SingletonPattern.getSingletonPatternInstance();

        if(singletonPatternInstance_01 == singletonPatternInstance_02){
            System.out.println("\nObject are same !!");
        }else{
            System.out.println("\nDifferent Objects !!");
        }

    }


}
