import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {
    // Directions for movement: Right, Left, Down, Up
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minMoves(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;

        // If the start is the same as the end
        if (n == 1 && m == 1) return 0;

        // BFS setup
        boolean[][] visited = new boolean[n][m]; // visited array to mark cells
        Queue<int[]> queue = new LinkedList<>();
        
        // Starting from (0,0)
        queue.offer(new int[]{0, 0, 0}); // {x, y, steps}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            // Explore all directions
            for (int[] direction : DIRECTIONS) {
                for (int step = 1; step <= k; step++) {
                    int newX = x + direction[0] * step;
                    int newY = y + direction[1] * step;

                    if(isInBounds(newX, newY, n, m) && maze[newX][newY] == 1) {
                        break; // Break the inner loop due to obstacle
                    }

                    // Check if we reached the end
                    if (newX == n - 1 && newY == m - 1) {
                        return steps + 1;
                    }

                    // Check if the new position is within bounds and not visited
                    if (isInBounds(newX, newY, n, m) && maze[newX][newY] == 0 && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY, steps + 1});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        // If no path is found, return -1
        return -1;
    }

    // Helper function to check if a position is within bounds
    private static boolean isInBounds(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0},
            {0, 1, 0, 1},
            {0, 0, 0, 0},
            {1, 1, 1, 0}
        };
        int k = 2;

        int result = minMoves(maze, k);
        if (result != -1) {
            System.out.println("Minimum number of moves: " + result);
        } else {
            System.out.println("No valid path found.");
        }
    }
}
