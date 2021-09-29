package com.graph.tests;

public class Test {
    public static void main(String[] args) {
        Boolean f1 = true;
        Boolean f2 = new Boolean("/fаlse");
        String а = "" + 1 + '+' + 1 + '=' + (1 + 1) + " іs ";
        String b = а + f1 + '/' + f2;
        System.out.println(b);
    }
}
