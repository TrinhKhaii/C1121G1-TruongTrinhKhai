package ss14_thuat_toan_sap_xep.bai_tap.install_quick_sort_algorithm;

import ss4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch.StopWatch;

import java.util.Random;

public class QuickSort {
    public static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int par = partition(arr, low, high);
            quickSort(arr, low, par - 1);
            quickSort(arr, par + 1, high);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int size = 500000000;

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

//        System.out.println("Mảng ban đầu:");
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }

        QuickSort ob = new QuickSort();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        quickSort(arr, 0, size - 1);
        stopWatch.end();

        System.out.println();
//        System.out.println("Mảng sau khi sắp xếp:");
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }
        System.out.println();
        System.out.println("Total times: "+ stopWatch.getElapsedTime() / 1000 + " s");
    }
}
