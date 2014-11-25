package com.company;

/**
 * Created by Katrin on 25.11.2014.
 */
public class QuickSort {
    public static int ARRAY_LENGTH = 30;
    private static int[] arr = new int[ARRAY_LENGTH];

    public static void initArray() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }

    public static void printArray() {
        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.printf("%3d\n", arr[ARRAY_LENGTH - 1]);
    }

    public static void quickSorting() {
        int startIndex = 0;
        int endIndex = ARRAY_LENGTH - 1;
        doSort(startIndex, endIndex);
    }

    private static void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur + 1, end);
    }

    public static void main(String[] args) {
        initArray();
        System.out.print("Original Array:  ");
        printArray();
        quickSorting();
        System.out.print("QuickSort Array: ");
        printArray();
    }
}
