package com.vips.shorties.java;

/**
 * Created by vipinsharma on 29/05/18.
 */
public class ObjectCreation {


    public void generateObjects() throws Exception{
        System.out.println("\nObject generation app \n");
        //01.
        DummyClass dummyObject01 = new DummyClass();
        System.out.println("01) dummyObject01 with random number as : "+dummyObject01.getRandomNumber());

        //02.
        DummyClass dummyObject02 = (DummyClass) Class.forName("com.vips.core.concepts.DummyClass").newInstance();
        System.out.println("02) dummyObject02 with random number as : "+dummyObject02.getRandomNumber());

        //03.
        DummyClass dummyObject03 = (DummyClass) dummyObject02.clone();
        System.out.println("03) dummyObject03 with random number as : "+dummyObject03.getRandomNumber());

        //04.
        DummyClass dummyObject04 = (DummyClass) DummyClass.class.getDeclaredConstructors()[0].newInstance();
        System.out.println("04) dummyObject04 with random number as : "+dummyObject04.getRandomNumber());

        //05.
        DummyClass dummyObject05 = (DummyClass)DummyClass.class.getClassLoader().loadClass("com.vips.core.concepts.DummyClass").newInstance();
        System.out.println("05) dummyObject05 with random number as : "+dummyObject05.getRandomNumber());
    }

    public static void main(String[] args) throws Exception{

        ObjectCreation objectCreation = new ObjectCreation();
        objectCreation.generateObjects();
    }



}
