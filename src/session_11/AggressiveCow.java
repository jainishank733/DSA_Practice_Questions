package session_11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AggressiveCow {

    static private boolean canPlaced(int[] stalls, int cows, int mid){
        int posPlaced=stalls[0];
        int numPlaced=1;
        for(int cur=1; cur<stalls.length;cur++){
            if(numPlaced==cows){
                return true;
            }
            if(stalls[cur]-posPlaced>=mid){
                numPlaced++;
                posPlaced=stalls[cur];
            }
        }
        return false;
    }

    static int findMinLargestDistance(int[] stalls, int cows){
        Arrays.sort(stalls);
        int n=stalls.length;
        int l=0, r=stalls[n-1]-stalls[0];
        while (r>l+1){
            int mid=(l+r)/2;
            if(canPlaced(stalls,cows,mid))
                l=mid;
            else
                r=mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;
        System.out.println(findMinLargestDistance(stalls,cows));
    }
}
