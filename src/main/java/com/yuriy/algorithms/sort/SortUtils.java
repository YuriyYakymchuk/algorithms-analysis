package com.yuriy.algorithms.sort;

public class SortUtils {

    public static void mergeSort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private static void mergeSort(Comparable[] array, Comparable[] aux, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, aux, start, mid);
        mergeSort(array, aux, mid + 1, end);
       /* if (array[mid + 1].compareTo(array[mid]) >= 0) {
            return;
        }*/
        merge(array, aux, start, end);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= end; i++) {
            aux[i] = array[i];
        }
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > end) {
                array[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

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

    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
