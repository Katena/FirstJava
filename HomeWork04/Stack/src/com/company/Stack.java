package com.company;

import java.util.ArrayList;


/**
 * Created by Katrin on 02.11.2014.
 */
public class Stack<T> {
    ArrayList<T> stack;
    int size = 0;

    public Stack() {
        stack = new ArrayList<T>();
    }

    public void push(T object) {
        stack.add(object);
        size++;
    }

    public T pop() {

        if (stack.size() > 0) {
            T temp = stack.get(size - 1);
            stack.remove(size - 1);
            size--;
            return temp;
        } else System.out.println("���� ����");

        return null;
    }


    public int getSize() {
        return size;
    }

    public void clear() {
        stack.clear();
        System.out.println("���� ����");
    }

    public int search(T object) {
        int j = 0;
        for (int i = stack.size() - 1; i > 0; i--) {
            j++;
            if (object.equals(stack.get(i))) {
                return j;
            }
        }
        System.out.println("������ �� ������");
        return -1;

    }
}
