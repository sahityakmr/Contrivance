package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 8, 7, 9, 4, 6, 8, 4, 9, 7, 1, 5, 1, 7, 5, 7, 4, 9, 4, 5, 7, 9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (end > start) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int item = array[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (array[i] < item) {
                if (i != j) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                j++;
            }
        }
        int temp = array[j];
        array[j] = array[end];
        array[end] = temp;
        return j;
    }
}
