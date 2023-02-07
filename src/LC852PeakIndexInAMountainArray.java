public class LC852PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3) {
            return arr[1];
        }

        return binarySearch(arr);
    }

    private int binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
                return middle;
            } else if (arr[middle] < arr[middle + 1]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return -1;
    }
}
