package com.javaelementary;

public class Main {
    public static void main(String[] args) {
        MyBigInteger bigInteger = new MyBigInteger(new int[]{6, 2, 3});
        System.out.println(bigInteger.add(new MyBigInteger("56888888888888888888888888888888888888888000000000000002")));
    }
}