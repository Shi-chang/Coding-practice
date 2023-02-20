import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> tempList = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return null;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        tempList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = tempList.get(tempList.size() - 1);

            if (last[1] >= cur[0]) {
                int end = Math.max(last[1], cur[1]);
                tempList.set(tempList.size() - 1, new int[]{last[0], end});
            } else {
                tempList.add(cur);
            }
        }

        int[][] res = tempList.toArray(new int[0][]);

        return res;
    }
}
