package Arrays;

// =====================================================
// 36. Valid Sudoku
// =====================================================

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board){

        int [][] boardInt = new int[9][9];
        //Replace char with int
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if (board[i][j] != '.') {
                    boardInt[i][j] = board[i][j] - '0';
                }else{
                    boardInt[i][j] = 0;
                }

            }
        }

        //Check Rows
        for (int i = 0; i<9; i++ ){
            HashSet<Integer> map = new HashSet<>();
            for (int j = 0; j<9; j++){
                if(boardInt[i][j] != 0 && !map.add(boardInt[i][j]))
                    return false;
            }
        }

        //Check Columns
        for (int i = 0; i<9; i++ ){
            HashSet<Integer> map = new HashSet<>();
            for (int j = 0; j<9; j++){
                if(boardInt[j][i] != 0 && !map.add(boardInt[j][i]))
                    return false;
            }
        }

        //Check 3x3
        for(int row = 0; row<9; row+=3){
            for(int col = 0; col<9; col+=3){
                int[][] miniBoard = new int[3][3];
                for(int i = 0; i<3;i++){
                    for(int j = 0; j<3;j++){
                        miniBoard[i][j] = boardInt[i+row][j+col];
                    }
                }
                if(!isValid(miniBoard))
                    return false;
            }
        }

        return true;
    }

    public boolean isValid(int[][] board){
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[j][i] != 0 && !map.add(board[j][i]))
                    return false;
            }
        }
        return true;
    }
}
