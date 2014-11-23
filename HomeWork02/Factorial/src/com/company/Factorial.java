package com.company;

import java.util.Scanner;

/**
 * Created by Katrin on 22.11.2014.
 */
public class Factorial {
    public static long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    public static void main(String[] args)

    {
        Scanner input = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = input.nextInt();

        System.out.println("Factorial of " + n + " is: " + factorial(n));

    }
}