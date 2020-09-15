package com.yuriy.algorithms.sort;

public class SortUtils {

    public static void bubbleSort(Comparable[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void mergeSort(Comparable[] array) {
        Comparable[] tempArray = new Comparable[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    private static void mergeSort(Comparable[] array, Comparable[] tempArray, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, tempArray, start, mid);
        mergeSort(array, tempArray, mid + 1, end);
        if (array[mid + 1].compareTo(array[mid]) >= 0) {
            return;
        }
        merge(array, tempArray, start, end);
    }

    private static void merge(Comparable[] array, Comparable[] tempArray, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++) {
            tempArray[i] = array[i];
        }
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                array[k] = array[j++];
            } else if (j > end) {
                array[k] = tempArray[i++];
            } else if (tempArray[i].compareTo(array[j]) < 0) {
                array[k] = tempArray[i++];
            } else {
                array[k] = array[j++];
            }
        }
    }

    public static void quickSort(Comparable[] array) {
        threeWayQuickSort(array, 0, array.length - 1);
    }

    private static void threeWayQuickSort(Comparable[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        Comparable v = array[start];
        int i = start + 1;
        int lessThanIndex = start;
        int greaterThanIndex = end;
        while (i <= greaterThanIndex) {
            int compareResult = array[i].compareTo(v);
            if (compareResult < 0) {
                swap(array, lessThanIndex, i);
                lessThanIndex++;
                i++;
            } else if (compareResult > 0) {
                swap(array, greaterThanIndex, i);
                greaterThanIndex--;
            } else {
                i++;
            }
        }
        threeWayQuickSort(array, start, lessThanIndex - 1);
        threeWayQuickSort(array, greaterThanIndex + 1, end);
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
