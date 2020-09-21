package com.yuriy.algorithms.find;

import static com.yuriy.algorithms.utils.FileHelper.readStrings;

public class SearchMain {

    private final static String UNSORTED_NAMES_FILE = "/UnsortedZipcodes.txt";

    public static void main(String[] args) {
        int n = 1000;

        String[] zipcodes = readStrings(UNSORTED_NAMES_FILE, n);

        System.out.println(zipcodes.length);
    }
}
