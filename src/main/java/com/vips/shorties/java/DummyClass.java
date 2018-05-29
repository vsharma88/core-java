package com.vips.shorties.java;

class DummyClass implements Cloneable{
        private double randomNumber = Math.random();

        public double getRandomNumber() {
            return randomNumber;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {return super.clone();
        }
    }