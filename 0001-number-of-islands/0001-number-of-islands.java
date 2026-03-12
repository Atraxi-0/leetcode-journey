class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    int rows = grid.length;
                    int cols = grid[i].length;
                    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
                    Queue<int[]> queue = new LinkedList<>();
                    grid[i][j] = '0';
                    queue.offer(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int dir[] : directions) {
                            int row = curr[0] + dir[0];
                            int col = curr[1] + dir[1];
                            if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1') {
                                grid[row][col] = '0';
                                queue.offer(new int[] { row, col });
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}