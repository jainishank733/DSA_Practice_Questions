package session_15;

import java.util.HashMap;
import java.util.Map;

public class CountNicePair {

    private static int rev(int n){
        int rev=0, digit;
        while(n>0){
            digit = n%10;
            n/=10;
            rev = rev*10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] arr = { 42, 11, 1, 97, 97 };
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++){
            int search = arr[i] - rev(arr[i]);
            if(map.containsKey(search)){
                count+=map.get(search);
            }
            map.put(search, map.getOrDefault(search, 0)+1);
        }
        System.out.println(count);
    }
}
