import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];

            if (map.containsKey(cur[1])) {
                map.get(cur[1]).add(cur[0]);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(cur[0]);
                map.put(cur[1], tempList);
            }

            inDegrees[cur[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            resList.add(cur);

            List<Integer> tempList = map.get(cur);

            if (tempList == null || tempList.size() == 0) {
                continue;
            }

            for (int i = 0; i < tempList.size(); i++) {
                inDegrees[tempList.get(i)]--;

                if (inDegrees[tempList.get(i)] == 0) {
                    queue.add(tempList.get(i));
                }
            }
        }

        if (resList.size() == numCourses) {
            return resList.stream().mapToInt(Integer::intValue).toArray();
        }

        return new int[0];
    }
}
