package com.example.controller;

public class test1 extends test {
    private String baseName = "sub";

    public void callName(){
        System.out.println(baseName);
    }

    public static void main(String[] args) {
        test test = new test1();
        test.callName();
    }
}
