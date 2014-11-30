package com.company;

/**
 * Created by Katrin on 30.11.2014.
 */
public class Collection {
    int size = 0;
    Contact[] arr;

    public void add(Contact number) {
        Contact[] newArray = new Contact[size + 1];
        if (size != 0) {

            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
        }
        newArray[size] = number;
        size++;
        arr = newArray;
    }

    public void remove(int index) {
        if (index < size && index >= 0) {
            if (size != 0) {
                if (size == 1) {
                    arr = null;
                    size = 0;
                    return;
                }

                Contact[] newArray = new Contact[size - 1];
                for (int i = 0; i < index; i++) {
                    newArray[i] = arr[i];
                }
                for (int i = index + 1; i < arr.length; i++) {
                    newArray[i - 1] = arr[i];
                }
                size--;
                arr = newArray;
            } else {
                System.err.println("Коллекция пуста");
            }
        } else {
            System.err.println("Индекс не существует");
        }


    }

    public void clear() {
        arr = null;
        size = 0;
    }

    public void insert(int index, Contact n) {
        if (index <= size && index >= 0) {
            if (size != 0) {
                Contact[] newArray = new Contact[size + 1];
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
                Contact[] newArray = new Contact[size + 1];
                newArray[size] = n;
                size++;
                arr = newArray;
            }
        } else {
            System.err.println("Индекс не существует");
        }
    }

}
