package com.yuriy.algorithms.data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FindMedianMain {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(10);
            list.add(number);
            medianFinder.addNum(number);
        }
        Collections.sort(list);
        printList(list);
        System.out.println("Median: " + medianFinder.findMedian());

        int number = random.nextInt(10);
        list.add(number);
        medianFinder.addNum(number);
        Collections.sort(list);
        printList(list);
        System.out.println("Median: " + medianFinder.findMedian());

        number = random.nextInt(10);
        list.add(number);
        medianFinder.addNum(number);
        Collections.sort(list);
        printList(list);
        System.out.println("Median: " + medianFinder.findMedian());
    }

    private static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.print(number + " ");
        }
        System.out.println("");
    }

}
