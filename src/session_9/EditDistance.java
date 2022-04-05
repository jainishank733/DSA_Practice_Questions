package session_9;

import java.util.Arrays;

public class EditDistance {

    static int sol(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 && m==0){
            return 0;
        }
        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return sol(s1,s2,n-1,m-1, dp);
        }
        else{
            int insert = sol(s1,s2,n,m-1, dp);
            int replace = sol(s1,s2,n-1,m-1, dp);
            int delete = sol(s1,s2,n-1,m, dp);
            return dp[n][m] = Math.min(insert, Math.min(replace,delete))+1;
        }
    }


    public static void main(String[] args) {
        String s1 = "intenstion";
        String s2 = "execution";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(sol(s1,s2,s1.length(),s2.length(),dp));
    }
}
