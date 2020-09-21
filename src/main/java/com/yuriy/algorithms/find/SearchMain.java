package com.yuriy.algorithms.find;

import static com.yuriy.algorithms.utils.FileHelper.readZipCodes;

public class SearchMain {

    private final static String UNSORTED_NAMES_FILE = "/UnsortedZipcodes.txt";

    public static void main(String[] args) {
        int n = 100000;

        ZipCode[] zipCodes = readZipCodes(UNSORTED_NAMES_FILE, n);

        BinarySearchTree<ZipCode, String> binarySearchTree = new BinarySearchTree<>();
        RedBlackTree<ZipCode, String> redBlackTree = new RedBlackTree<>();

        for (ZipCode zipCode : zipCodes) {
            binarySearchTree.put(zipCode, zipCode.toString());
            redBlackTree.put(zipCode, zipCode.toString());
        }

        ZipCode zipCode = zipCodes[zipCodes.length - 1];
        System.out.println("ZipCode to find: " + zipCode);

        long start = System.currentTimeMillis();
        for (int i = 0; i < zipCodes.length; i++) {
            if (zipCodes[i].equals(zipCode)) {
                System.out.println("Sequential search result: " + zipCodes[i]);
                break;
            }
        }
        System.out.println(String.format("Sequential search took: %d ms", System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("BST search result: " + binarySearchTree.get(zipCode));
        System.out.println(String.format("BST search took: %d ms", System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("Red-black Tree search result: " + redBlackTree.get(zipCode));
        System.out.println(String.format("Red-black search took: %d ms", System.currentTimeMillis() - start));
    }
}
