package com.company;

/**
 * Created by Katrin on 02.12.2014.
 */
public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 11; i++) {
            stack.push(i);

        }

        System.out.print("номер в очереди: ");
        System.out.println(stack.search(7));
        stack.clear();

    }
}


