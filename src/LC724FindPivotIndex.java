public class LC724FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int leftTotal = curSum - nums[i];
            int rightTotal = sum - curSum;
            if (leftTotal == rightTotal) {
                return i;
            }
        }

        return -1;
    }
}
