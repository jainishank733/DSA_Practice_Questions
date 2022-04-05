package session_8;

import java.util.Arrays;

public class CoinChangeTwo {

    public static int sol(int[] coin, int curr, int n, int amount, int[][] dp){
        int inc = 0, exl = 0;
        if(amount == 0){
            return 1;
        }
        if(curr == n){
            return 0;
        }
        if(dp[curr][amount] != -1){
            return dp[curr][amount];
        }
        if(coin[curr] <= amount){
            inc = sol(coin, curr, n, amount - coin[curr], dp);
        }
        exl = sol(coin, curr+1, n, amount, dp);
        return dp[curr][amount] = inc + exl;
    }

    public static void main(String[] args) {
        int[] coin = {1,2,5};
        int count=3;
        int amount = 5;
        int[][] dp = new int[count+1][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(sol(coin, 0, 3, 5, dp));
    }

}
