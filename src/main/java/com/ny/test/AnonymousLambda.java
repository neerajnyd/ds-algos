package com.ny.test;

public class AnonymousLambda {
    public static void main(String[] args) {
        MyRunnable mr = () -> System.out.println(MyRunnable.a);
        mr.showData();
         /*MyRunnable mr2= ()-> System.out.println(a);*///Can not write the lambda for this Functional Interface
        MyRunnable mr3 = () -> System.out.println("Allowed");//Functional Interface implementation for showData()
        mr3.showData();
    }
}
