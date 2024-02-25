package com.blog;

import java.util.Scanner;

public class TernaryOprator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Number : ");
        int i = sc.nextInt();
        String s = (i % 2 == 0) ? "even" : "odd";
        System.out.println(s);

    }
}
