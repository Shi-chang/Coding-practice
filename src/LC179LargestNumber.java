import java.util.Arrays;

public class LC179LargestNumber {

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsStr.length; i++) {
            sb.append(numsStr[i]);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }
}
