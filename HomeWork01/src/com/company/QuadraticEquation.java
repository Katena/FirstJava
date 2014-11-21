package com.company;

/**
 * Created by Katrin on 21.11.2014.
 */

import java.util.Scanner;

public class QuadraticEquation {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input a: ");
        double a = input.nextDouble();

        System.out.print("Input b: ");
        double b = input.nextDouble();

        System.out.print("Input c: ");
        double c = input.nextDouble();

        double D = Math.pow(b, 2) - (4 * a * c);

        System.out.print("Result: ");

        if (D > 0) {
            double x1 = ((-1) * b - Math.sqrt(D)) / (2 * a);
            double x2 = ((-1) * b + Math.sqrt(D)) / (2 * a);
            System.out.println("X1: " + x1);
            System.out.println("        X2: " + x2);

        } else if (D == 0) {
            double x1 = ((-1) * b - Math.sqrt(D)) / (2 * a);
            System.out.println("X1=X2: " + x1);
        } else {
            System.out.println("D minus");
        }
    }

}
