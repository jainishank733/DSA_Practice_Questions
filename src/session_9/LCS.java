package session_9;

import java.util.Arrays;

public class LCS {

    public static int lcs(String s, String t, int n, int m, int[][] dp){
        if(m==0 || n==0)
            return 0;
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s.charAt(n-1) == t.charAt(m-1)){
            return dp[n][m] = 1 + lcs(s,t,n-1,m-1, dp);
        }else{
            int c1 = lcs(s,t,n-1,m, dp);
            int c2 = lcs(s,t,n,m-1, dp);
            return dp[n][m] = Math.max(c1,c2);
        }
    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="def";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        System.out.println(lcs(s1,s2,s1.length(),s2.length(),dp));
    }
}
