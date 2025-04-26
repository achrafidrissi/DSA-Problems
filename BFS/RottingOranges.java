package BFS;

// =====================================================
// 994. Rotting Oranges
// =====================================================

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> rottedOranges = new LinkedList<>();

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++){
                if(grid[i][j] == 2)
                    rottedOranges.offer(new int[] {i, j});
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges==0) return 0;

        int[][] directions = {{-1,0},{1,0}, {0,-1},{0,1}};
        int minutes = 0;

        while (!rottedOranges.isEmpty()) {
            boolean rotted = false;
            int size = rottedOranges.size();
            for (int i = 0; i < size; i++) {
                int[] currentPos = rottedOranges.poll();
                int row = currentPos[0];
                int col = currentPos[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        rottedOranges.offer(new int[]{newRow, newCol});
                        rotted = true;
                    }
                }
            }
            if(rotted)
                minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
