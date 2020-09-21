package com.yuriy.algorithms.utils;

import com.yuriy.algorithms.find.ZipCode;
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

    public static ZipCode[] readZipCodes(String fileName, int n) {
        ZipCode[] zipCodes = new ZipCode[n];
        int i = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(SOURCE_PATH.toAbsolutePath() + fileName)))){
            while (scanner.hasNext() && i < n) {
                zipCodes[i++] = new ZipCode(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Failed to read from the file.");
        }
        return zipCodes;
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
