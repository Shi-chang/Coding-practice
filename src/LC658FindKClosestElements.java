import java.util.ArrayList;
import java.util.List;

/**
 * LC658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the
 * array. The result should also be sorted in ascending order.
 */
public class LC658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x <= arr[0]) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (x >= arr[arr.length - 1]) {
            List<Integer> result = new ArrayList<>();
            for (int i = arr.length - k; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        int searchResult = binarySearch(arr, x);
        return findClosestElements(arr, k, x, searchResult, searchResult + 1);
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    private List<Integer> findClosestElements(int[] arr, int k, int x, int left, int right) {
        List<Integer> result = new ArrayList<>();
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
                continue;
            }
            if (right > arr.length - 1) {
                left--;
                continue;
            }
            if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
