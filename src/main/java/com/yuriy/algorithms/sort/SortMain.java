package com.yuriy.algorithms.sort;

import java.util.Arrays;

import static com.yuriy.algorithms.utils.FileHelper.readInts;
import static com.yuriy.algorithms.utils.FileHelper.writeToFile;

public class SortMain {

    private final static String UNSORTED_ARRAY_FILE = "/UnsortedArray.txt";
    private final static String BUBBLE_SORT_FILE = "/BubbleSort.txt";
    private final static String MERGE_SORT_FILE = "/MergeSort.txt";
    private final static String QUICK_SORT_FILE = "/QuickSort.txt";

    public static void main(String[] args) {

        int n = 10000;

        Integer[] unsortedArray = readInts(UNSORTED_ARRAY_FILE, n);

        Integer[] bubbleSortArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        long start = System.currentTimeMillis();
        SortUtils.bubbleSort(bubbleSortArray);
        System.out.println(String.format("Bubble sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(BUBBLE_SORT_FILE, bubbleSortArray);

        Integer[] mergeSortArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        start = System.currentTimeMillis();
        SortUtils.mergeSort(mergeSortArray);
        System.out.println(String.format("Merge sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(MERGE_SORT_FILE, mergeSortArray);

        Integer[] quickSortArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        start = System.currentTimeMillis();
        SortUtils.quickSort(quickSortArray);
        System.out.println(String.format("Quick sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(QUICK_SORT_FILE, quickSortArray);
    }

}
