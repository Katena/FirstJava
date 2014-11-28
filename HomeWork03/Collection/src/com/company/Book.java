package com.company;

/**
 * Created by Katrin on 28.11.2014.
 */
public class Book {
    public static void main(String[] args) {
        Collection book = new Collection();

        book.add(1);
        book.add(2);
        book.add(3);

        System.out.println("Size: " + book.size);
        for (int i = 0; i < book.size; i++) {
            System.out.printf("%3d", book.arr[i]);
        }
        System.out.println();

        book.insert(1, 7);
        System.out.println("Size: " + book.size);
        for (int i = 0; i < book.size; i++) {
            System.out.printf("%3d", book.arr[i]);
        }
        System.out.println();

        book.clear();
        System.out.println("Size: " + book.size);
        for (int i = 0; i < book.size; i++) {
            System.out.printf("%3d", book.arr[i]);
        }
    }
}
