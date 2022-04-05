package session_15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOnePass {

    public static void main(String[] args) {
        int[] arr = {3,3};
        int n = arr.length;
        int target = 6;
        Map<Integer,Integer> map = new HashMap<>();
        int[] pair = new int[2];

        for(int i=0;i<n;i++){
            int search = target - arr[i];
            if(map.containsKey(search)){
                pair[0] = map.get(search);
                pair[1] = i;
                break;
            }
            map.put(arr[i],i);
        }
        System.out.println(Arrays.toString(pair));
    }
}
