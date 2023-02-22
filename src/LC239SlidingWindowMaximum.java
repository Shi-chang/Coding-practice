import java.util.ArrayDeque;
import java.util.Deque;

public class LC239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // To ensure that the max element will be picked only after a window is formed
            int startWindowIndex = i - k + 1;

            if (deque.size() != 0 && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while (deque.size() != 0 && deque.peekLast() <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (startWindowIndex >= 0) {
                res[startWindowIndex] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
