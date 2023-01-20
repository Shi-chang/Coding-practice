/**
 * LC941. Valid Mountain Array
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 */
public class LC941ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return false;
        }

        int idx = 0;

        while (idx < arr.length - 1 && arr[idx] < arr[idx + 1]) {
            idx++;
        }

        if (idx == 0 || idx == arr.length - 1) {
            return false;
        }

        while (idx < arr.length - 1 && arr[idx] > arr[idx + 1]) {
            idx++;
        }

        return idx == arr.length - 1;
    }
}
