import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] topElement = queue.peek();
            if (cur[0] >= topElement[1]) {
                queue.poll();
            }
            queue.offer(cur);
        }

        return queue.size();
    }
}

// class Solution {
//     public int minMeetingRooms(int[][] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return 0;
//         }

//         if (intervals.length == 1) {
//             return 1;
//         }

//         List<int[]> tempList = new ArrayList<>();

//         // 0 - 0-1; 1 - 2-3; 2 - 4 -5; 3 - 6 -7
//         for (int i = 0; i < intervals.length; i++) {
//             tempList.add(new int[]{intervals[i][0], 1});
//             tempList.add(new int[]{intervals[i][1], -1});
//         }

//         Collections.sort(tempList, (a, b) -> {
//             if (a[0] != b[0]) {
//                 return a[0] - b[0];
//             }
//             return a[1] - b[1];
//         });

//         int count = 0;
//         int maxCount = 0;

//         for (int[] cur : tempList) {
//             if (cur[1] == 1) {
//                 count++;
//                 maxCount = Math.max(maxCount, count);
//             } else {
//                 count--;
//             }
//         }

//         return maxCount;
//     }
// }
