import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1272RemoveInterval {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return res;
        }

        if (toBeRemoved == null && toBeRemoved.length == 0) {
            for (int i = 0; i < intervals.length; i++) {
                List<Integer> temp = Arrays.asList(intervals[i][0], intervals[i][1]);
                res.add(temp);
            }

            return res;
        }

        int i = 0;
        while (i < intervals.length && intervals[i][1] <= toBeRemoved[0]) {
            List<Integer> temp = Arrays.asList(intervals[i][0], intervals[i][1]);
            res.add(temp);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= toBeRemoved[1]) {
            List<Integer> temp;
            if (intervals[i][0] < toBeRemoved[0] && intervals[i][1] > toBeRemoved[1]) {
                temp = Arrays.asList(intervals[i][0], toBeRemoved[0]);
                res.add(temp);
                temp = Arrays.asList(toBeRemoved[1], intervals[i][1]);
                res.add(temp);
            } else if (intervals[i][0] < toBeRemoved[0]) {
                temp = Arrays.asList(intervals[i][0], toBeRemoved[0]);
                res.add(temp);
            } else if (intervals[i][1] > toBeRemoved[1]) {
                temp = Arrays.asList(toBeRemoved[1], intervals[i][1]);
                res.add(temp);
            }
            i++;
        }

        while (i < intervals.length) {
            List<Integer> temp = Arrays.asList(intervals[i][0], intervals[i][1]);
            res.add(temp);
            i++;
        }

        return res;
    }
}
