package com.company;

/**
 * Created by Katrin on 28.11.2014.
 */
public class Collection {
    int size = 0;
    int[] arr;

    public void add(int number) {
        int[] newArray = new int[size + 1];
        if (size != 0) {

            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
        }
        newArray[size] = number;
        size++;
        arr = newArray;
    }

    public void clear() {
        arr = null;
        size = 0;
    }

    public void insert(int index, int n) {
        if (index <= size && index >= 0) {
            if (size != 0) {
                int[] newArray = new int[size + 1];
                for (int i = 0; i < index; i++) {
                    newArray[i] = arr[i];
                }
                newArray[index] = n;

                for (int i = index + 1; i <= arr.length; i++) {
                    newArray[i] = arr[i - 1];
                }
                size++;
                arr = newArray;
            } else {
                int[] newArray = new int[size + 1];
                newArray[size] = n;
                size++;
                arr = newArray;
            }
        } else {
            System.err.println("Индекс не существует");
        }

    }
}
