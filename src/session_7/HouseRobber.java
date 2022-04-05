package session_7;

import java.util.Arrays;

public class HouseRobber {

    static int sol(int[] houses, int curr, int n, int[] dp){
        if(curr>=n){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int rob = houses[curr] + sol(houses,curr+2, n, dp);
        int dontRob = sol(houses,curr+1,n, dp);
        return dp[n] = Math.max(rob, dontRob);
    }

    public static void main(String[] args) {
        int[] house = {1,2,3,9};
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(sol(house,0,n, dp));
    }
}
