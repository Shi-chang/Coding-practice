public class LC209MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int slow = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum < target) {
                continue;
            }

            while (sum >= target) {
                res = Math.min(res, i - slow + 1);
                sum -= nums[slow];
                slow++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
