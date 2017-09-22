package com.vips.design.pattern;

import java.awt.*;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 20/09/17
 **/
public class FactoryPattern {

    enum SHAPE {
        CIRCLE, SQUARE, RECTANGLE
    };

    public static Shape getInstance(SHAPE shape) throws Exception{
      Shape result;
        switch (shape){
            case CIRCLE: result = new Circle();
                break;
            case SQUARE: result = new Square();
                break;
            case RECTANGLE: result = new Rectangle();
                break;
             default:
                 throw new Exception("Invalid object name !!");
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        FactoryPattern.getInstance(SHAPE.CIRCLE).printDetails();
        FactoryPattern.getInstance(SHAPE.SQUARE).printDetails();
        FactoryPattern.getInstance(SHAPE.RECTANGLE).printDetails();
    }
}
    interface Shape{
      void printDetails();
    }

    class Circle implements Shape {
        @Override
        public void printDetails() {
            System.out.println("\nI am circle object");
        }
    }

    class Square implements Shape {
        @Override
        public void printDetails() {
            System.out.println("\nI am Square object");
        }
    }

    class Rectangle implements Shape {
        @Override
        public void printDetails() {
            System.out.println("\nI am Rectangle object");
        }
    }

