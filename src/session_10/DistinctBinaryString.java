package session_10;

import java.util.Arrays;

public class DistinctBinaryString {

    private static int sol(int cur){
        if(cur<0){
            return 0;
        }
        int once=0, twice=0;
        if(cur!=1){
            twice = sol(cur-2);
        }
        once = sol(cur-1);
        return 1+once+twice;
    }

    public static void main(String[] args) {
        System.out.println(sol(2));
    }
}
