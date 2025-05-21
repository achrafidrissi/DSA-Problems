package DailyChallenge;

// =====================================================
// 73. Set Matrix Zeroes
// =====================================================

import java.util.ArrayList;

public class SetMatrixZeroes_15 {

    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<int[]> zeroPositions = new ArrayList<>();

        for (int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                if(matrix[i][j] == 0){
                    zeroPositions.add(new int[]{i,j});
                }
            }
        }

        for (int[] zeroPosition : zeroPositions){
            int row = zeroPosition[0];
            int col = zeroPosition[1];
            for (int i = 0; i < m; i++){
                matrix[i][col] = 0;
            }
            for (int i = 0; i < n; i++){
                matrix[row][i] = 0;
            }
        }
    }
}
