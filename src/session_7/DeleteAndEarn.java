package session_7;

import java.util.*;

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int e: nums){
            max=Math.max(max,e);
        }
        int[] freq = new int[max+1];
        for(int e:nums){
            freq[e]+=e;
        }
        int[] dp = new int[freq.length+1];
        Arrays.fill(dp,-1);
        System.out.println(sol(freq,0,freq.length,dp));
        return 0;
    }

    private static int sol(int[] freq, int curr, int n, int[] dp){
        if(curr>=n){
            return 0;
        }
        if(dp[curr]!=-1){
            return dp[curr];
        }
        int aquire = freq[curr] + sol(freq, curr+2, n, dp);
        int dontAquire = sol(freq, curr+1, n, dp);
        return dp[curr] = Math.max(aquire,dontAquire);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        deleteAndEarn(arr);
    }

}
