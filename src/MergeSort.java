/**
 * Merge sort. Time complexity = O(n log n), space complexity = O(n).
 */
class MergeSort {
    public static int[] mergeSort(int[] array) {
        // Write your code here.
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);

        return array;
    }

    private static void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(array, start, (start + end) / 2, temp);
        mergeSort(array, (start + end) / 2 + 1, end, temp);
        merge(array, start, end, temp);
    }

    private static void merge(int[] array, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIdx = start;
        int rightIdx = middle + 1;
        int tempIdx = start;

        while (leftIdx <= middle && rightIdx <= end) {
            if (array[leftIdx] < array[rightIdx]) {
                temp[tempIdx++] = array[leftIdx++];
            } else {
                temp[tempIdx++] = array[rightIdx++];
            }
        }

        while (leftIdx <= middle) {
            temp[tempIdx++] = array[leftIdx++];
        }

        while (rightIdx <= end) {
            temp[tempIdx++] = array[rightIdx++];
        }

        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }
    }
}
