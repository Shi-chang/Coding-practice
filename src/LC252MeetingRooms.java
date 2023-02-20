import java.util.Arrays;

/**
 * Leetcode 252. Meeting Rooms
 */
public class LC252MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        boolean flag = true;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
