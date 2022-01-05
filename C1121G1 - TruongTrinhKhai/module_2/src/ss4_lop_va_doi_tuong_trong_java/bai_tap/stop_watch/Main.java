package ss4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }
        StopWatch stopWatch = new StopWatch();
        System.out.println("Start time (milliseconds): " + stopWatch.getStartTime());
        stopWatch.start();

        selectionSort(arr, size);

        System.out.println("End time (milliseconds): " + stopWatch.getEndTime());
        stopWatch.end();
        System.out.println("Total (milliseconds): " + stopWatch.getElapsedTime() + " ~ " + stopWatch.getElapsedTime() / 1000 + " seconds");

    }
    public static void selectionSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
