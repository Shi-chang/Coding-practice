import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LintCode391NumberOfFlightsInTheSky {

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<int[]> tempList = new ArrayList<>();

        for (Interval interval : airplanes) {
            tempList.add(new int[]{interval.start, 1});
            tempList.add(new int[]{interval.end, -1});
        }

        // (4, 1) (4, -1)
        Collections.sort(tempList, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int maxCount = 0;
        int curCount = 0;

        for (int[] temp : tempList) {
            if (temp[1] == 1) {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            } else {
                curCount--;
            }
        }

        return maxCount;
    }
}

class Interval {

    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
