package com.yuriy.algorithms;

import com.yuriy.algorithms.sort.SortUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private final static Path SOURCE_PATH = Paths.get(Main.class.getResource("/").getPath());
    private final static String UNSORTED_ARRAY_FILE = "/UnsortedArray.txt";
    private final static String BUBBLE_SORT_FILE = "/BubbleSort.txt";
    private final static String MERGE_SORT_FILE = "/MergeSort.txt";
    private final static String QUICK_SORT_FILE = "/QuickSort.txt";

    public static void main(String[] args) {

        Integer[] bubbleSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE);
        long start = System.currentTimeMillis();
      //  SortUtils.bubbleSort(bubbleSortArray);
        System.out.println(String.format("Bubble sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(SOURCE_PATH.toAbsolutePath() + BUBBLE_SORT_FILE, bubbleSortArray);

        Integer[] mergeSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE);
        start = System.currentTimeMillis();
        SortUtils.mergeSort(mergeSortArray);
        System.out.println(String.format("Merge sort: %d ms", System.currentTimeMillis() - start));
        writeToFile(SOURCE_PATH.toAbsolutePath() + MERGE_SORT_FILE, mergeSortArray);

        Integer[] quickSortArray = readFile(SOURCE_PATH.toAbsolutePath() + UNSORTED_ARRAY_FILE);
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

    private static Integer[] readFile(String fileName) {
        Integer[] array = new Integer[1000000];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))){
            while (scanner.hasNext() && i < 1000000) {
                array[i++] = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return array;
    }
}
