/**
 * LC283. Move Zeros
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class LC283MoveZeros {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }

            if (fast < nums.length) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
