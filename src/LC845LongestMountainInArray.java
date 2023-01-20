/**
 * LC845. Longest Mountain in Array
 * Given an integer array arr, return the length of the longest subarray, which is a mountain.
 * Return 0 if there is no mountain subarray.
 */
public class LC845LongestMountainInArray {
    public int longestMountain(int[] arr) {
        if (arr.length <= 2) {
            return 0;
        }

        int longest = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;

                while (left >= 1 && arr[left] > arr[left - 1]) {
                    left--;
                }

                while (right <= arr.length - 2 && arr[right] > arr[right + 1]) {
                    right++;
                }

                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest;
    }
}
