import java.util.LinkedList;
import java.util.Queue;

public class LC1926NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze.length;
        boolean[][] isVisited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        isVisited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : directions) {
                    int curRow = cur[0] + dir[0];
                    int curCol = cur[1] + dir[1];

                    if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols) {
                        continue;
                    }

                    if (maze[curRow][curCol] == '+') {
                        continue;
                    }

                    if (isVisited[curRow][curCol] == true) {
                        continue;
                    }

                    if (curRow == 0 || curRow == rows - 1 || curCol == 0 || curCol == cols - 1) {
                        return steps;
                    }

                    queue.offer(new int[]{curRow, curCol});
                    isVisited[curRow][curCol] = true;
                }
            }
        }

        return -1;
    }
}