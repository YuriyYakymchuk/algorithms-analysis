package com.yuriy.algorithms.sort;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SortMain {

    private static Path SOURCE_PATH = null;

    static {
        try {
            SOURCE_PATH = Paths.get(SortMain.class.getResource("/").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private final static String UNSORTED_ARRAY_FILE = "/UnsortedArray.txt";
    private final static String BUBBLE_SORT_FILE = "/BubbleSort.txt";
    private final static String MERGE_SORT_FILE = "/MergeSort.txt";
    private final static String QUICK_SORT_FILE = "/QuickSort.txt";

    public static void main(String[] args) {

        int n = 10000;

        Integer[] bubbleSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE, n);
        long start = System.currentTimeMillis();
        SortUtils.bubbleSort(bubbleSortArray);
        System.out.println(String.format("Bubble sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(SOURCE_PATH.toAbsolutePath() + BUBBLE_SORT_FILE, bubbleSortArray);

        Integer[] mergeSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE, n);
        start = System.currentTimeMillis();
        SortUtils.mergeSort(mergeSortArray);
        System.out.println(String.format("Merge sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(SOURCE_PATH.toAbsolutePath() + MERGE_SORT_FILE, mergeSortArray);

        Integer[] quickSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE, n);
        start = System.currentTimeMillis();
        SortUtils.quickSort(quickSortArray);
        System.out.println(String.format("Quick sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(SOURCE_PATH.toAbsolutePath() + QUICK_SORT_FILE, quickSortArray);
    }

    private static void writeToFile (String fileName, Integer[] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));){
            for (Integer number : array) {
                writer.write(number + "\n");
            }
        } catch (IOException e) {
            System.out.println("Failed to write to the file.");
        }
    }

    private static Integer[] readFile(String fileName, int n) {
        Integer[] array = new Integer[n];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))){
            while (scanner.hasNext() && i < n) {
                array[i++] = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return array;
    }
}
