import java.util.List;
import java.util.ArrayList;

public class LC57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tempList = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            tempList.add(newInterval);
            return tempList.toArray(new int[0][]);
        }

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            tempList.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        tempList.add(newInterval);

        while (i < intervals.length) {
            tempList.add(intervals[i]);
            i++;
        }

        return tempList.toArray(new int[0][]);
    }
}
