import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            // [1, 0]
            int[] cur = prerequisites[i];

            if (map.containsKey(cur[1])) {
                List<Integer> curList = map.get(cur[1]);
                curList.add(cur[0]);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(cur[0]);
                map.put(cur[1], newList);
            }

            inDegree[cur[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            List<Integer> curList = map.get(cur);

            if (curList == null || curList.size() == 0) {
                continue;
            }

            for (int i = 0; i < curList.size(); i++) {
                inDegree[curList.get(i)]--;

                if (inDegree[curList.get(i)] == 0) {
                    queue.offer(curList.get(i));
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
