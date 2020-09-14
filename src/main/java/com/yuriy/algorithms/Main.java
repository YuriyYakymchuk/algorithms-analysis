package com.yuriy.algorithms;

import com.yuriy.algorithms.sort.SortUtils;

import java.io.*;
import java.util.Scanner;

public class Main {

    private final static String UNSORTED_ARRAY_FILE = "C:\\Git\\BEST\\algorithms-analysis\\src\\main\\resources\\UnsortedArray.txt";
    private final static String BUBBLE_SORT_FILE = "C:\\Git\\BEST\\algorithms-analysis\\src\\main\\resources\\BubbleSort.txt";
    private final static String MERGE_SORT_FILE = "C:\\Git\\BEST\\algorithms-analysis\\src\\main\\resources\\MergeSort.txt";
    private final static String QUICK_SORT_FILE = "C:\\Git\\BEST\\algorithms-analysis\\src\\main\\resources\\QuickSort.txt";

    public static void main(String[] args) {
        Integer[] bubbleSortArray = readFile();
        long start = System.currentTimeMillis();
        SortUtils.bubbleSort(bubbleSortArray);
        System.out.println(String.format("Bubble sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(BUBBLE_SORT_FILE, bubbleSortArray);

        Integer[] mergeSortArray = readFile();
        start = System.currentTimeMillis();
        SortUtils.mergeSort(mergeSortArray);
        System.out.println(String.format("Merge sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(MERGE_SORT_FILE, mergeSortArray);
    }

    private static void writeToFile (String fileName, Integer[] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));){
            for (Integer number : array) {
                writer.write(number + "\n");
            }
        } catch (IOException e) {
            System.out.println("Failed to write to the file.");
        }
    }

    private static Integer[] readFile() {
        Integer[] array = new Integer[1000000];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(UNSORTED_ARRAY_FILE)))){
            while (scanner.hasNext() && i < 1000000) {
                array[i++] = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return array;
    }
}
