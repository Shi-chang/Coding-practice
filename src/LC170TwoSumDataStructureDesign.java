import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 170. Two Sum III - Data structure design.
 */
class LC170TwoSumDataStructureDesign {
    private List<Integer> list;

    public LC170TwoSumDataStructureDesign() {
        list = new ArrayList<>();
    }

    /**
     * Add the number with insertion sort. Time complexity = O(k).
     */
    public void add(int number) {
        if (list.size() == 0) {
            list.add(number);
            return;
        }

        list.add(number);
        int idx = list.size() - 2;
        while (idx >= 0 && list.get(idx) > number) {
            list.set(idx + 1, list.get(idx));
            idx--;
        }

        list.set(idx + 1, number);
    }

    /**
     * Find the value with two-pointer method. Time complexity = O(k).
     */
    public boolean find(int value) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left) + list.get(right) == value) {
                return true;
            } else if (list.get(left) + list.get(right) < value) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */