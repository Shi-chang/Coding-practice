/**
 * LC34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value.
 */
public class LC34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = findStartingPosition(nums, target);
        int end = findEndingPosition(nums, target);
        return new int[]{start, end};
    }

    private int findStartingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                result = middle;
                right = middle - 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }

    private int findEndingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                result = middle;
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }
}
