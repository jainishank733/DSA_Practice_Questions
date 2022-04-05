package session_9;

import java.util.Arrays;

public class UncrossedLine {
    public static int uncrossedLine(int[] num1, int[] num2, int n, int m, int[][] dp){
        if(m==0 || n==0)
            return 0;
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(num1[n-1] == num2[m-1]){
            return dp[n][m] = 1 + uncrossedLine(num1, num2,n-1,m-1, dp);
        }else{
            int c1 = uncrossedLine(num1, num2,n-1,m, dp);
            int c2 = uncrossedLine(num1 ,num2,n,m-1, dp);
            return dp[n][m] = Math.max(c1,c2);
        }
    }

    public static void main(String[] args) {
        int[] num1 = {2,5,1,2,5};
        int[] num2 = {10,5,2,1,5,2};
        int[][] dp = new int[num1.length+1][num2.length+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        System.out.println(uncrossedLine(num1,num2,num1.length,num2.length,dp));
    }
}
