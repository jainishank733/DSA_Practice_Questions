package session_9;

import java.util.Arrays;

public class MinPathSum {

    public static int minPathSum(int[][] grid, int row, int col, int er, int ec, int[][] dp){
        if(row>er || col>ec){
            return Integer.MAX_VALUE;
        }
        if(row==er && col==ec){
            return grid[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int right = minPathSum(grid, row+1, col, er, ec, dp);
        int down = minPathSum(grid, row, col+1, er, ec, dp);
        return dp[row][col] = Math.min(right,down) + grid[row][col];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(minPathSum(grid, 0, 0, 2, 2, dp));
    }
}
