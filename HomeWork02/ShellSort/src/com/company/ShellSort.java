package com.company;

/**
 * Created by Katrin on 23.11.2014.
 */

public class ShellSort {
    public static void main(String[] args) {

        int size = 10;

        int[] arr = new int[size];

        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) (Math.random() * 100);
        }

        System.out.print("Original Array: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println();

        int step = size / 2;
        while (step > 0) {
            for (int i = 0; i < (size - step); i++) {
                int j = i;
                while (j >= 0 && arr[j] > arr[j + step]) {

                    int temp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
        }

        System.out.print("ShellSort Array: ");
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j] + " ");
        }

    }
}
