package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 9, 5, 6, 4, 8, 4, 9, 1, 5, 3, 4, 9, 7, 8, 1, 6, 4, 9};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];
        System.arraycopy(array, start, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);
        int i = 0, j = 0, k = start;
        while (i < leftArray.length && j < rightArray.length)
            array[k++] = (leftArray[i] < rightArray[j]) ? leftArray[i++] : rightArray[j++];
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }
}
