package com.yuriy.algorithms;

import com.yuriy.algorithms.sort.SortUtils;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 1, 0, 4, 2, 1, 10, 7};
        SortUtils.bubbleSort(array);
        for (Integer i: array) {
            System.out.print(i + " ");
        }
    }
}
