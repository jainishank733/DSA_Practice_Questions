package session_8;

import java.util.Arrays;

public class KnapsackZeroOne {

    private static int maxProfit(int[] price, int[] weight, int bagC, int curr, int[][] dp){
        if(bagC == 0 || curr == price.length){
            return 0;
        }
        if(dp[curr][bagC] != -1){
            return dp[curr][bagC];
        }
        int rob = 0, dontRob = 0;
        if(weight[curr]<=bagC){
            rob = price[curr] + maxProfit(price, weight, bagC-weight[curr], curr+1, dp);
        }
        dontRob = maxProfit(price, weight, bagC, curr+1, dp);
        return dp[curr][bagC] = Math.max(rob,dontRob);
    }

    public static void main(String[] args) {
        int[] price = {20,10,30,40};
        int[] wt = {2,1,4,5};
        int bagC=6, n=4;
        int[][] dp = new int[n+1][bagC+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(maxProfit(price, wt, bagC, 0, dp));
    }
}
