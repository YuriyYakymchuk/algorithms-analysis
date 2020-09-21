package com.yuriy.algorithms.utils;

import com.yuriy.algorithms.sort.SortMain;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHelper {

    private static Path SOURCE_PATH = null;

    static {
        try {
            SOURCE_PATH = Paths.get(SortMain.class.getResource("/").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] readInts(String fileName, int n) {
        Integer[] array = new Integer[n];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(SOURCE_PATH.toAbsolutePath() + fileName)))){
            while (scanner.hasNext() && i < n) {
                array[i++] = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return array;
    }

    public static String[] readStrings(String fileName, int n) {
        String[] array = new String[n];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(SOURCE_PATH.toAbsolutePath() + fileName)))){
            while (scanner.hasNext() && i < n) {
                array[i++] = scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return array;
    }

    public static void writeToFile (String fileName, Object[] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SOURCE_PATH.toAbsolutePath() + fileName, false));){
            for (Object object : array) {
                writer.write(object + "\n");
            }
        } catch (IOException e) {
            System.out.println("Failed to write to the file.");
        }
    }
}
