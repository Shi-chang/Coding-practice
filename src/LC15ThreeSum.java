import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC15 3Sum.
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j,
 * i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
public class LC15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            // Remove duplication
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];

                if (threeSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    // Remove duplication
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (threeSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
