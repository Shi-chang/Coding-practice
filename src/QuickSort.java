class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);

        return array;
    }

    /**
     * Partitions the array.
     *
     * @param array the array to be partitioned
     * @param start the start index
     * @param end   the end index
     */
    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = array[start + (end - start) / 2];

        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(array, start, right);
        quickSort(array, left, end);
    }
}
