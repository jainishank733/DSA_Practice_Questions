package session_14;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 1, 1, 2, 2};
        int n = arr.length;
        Map<Integer,Integer> majELe = new HashMap<>();
        for(int i=0;i<n;i++){
            if(majELe.containsKey(arr[i])){
                int val = majELe.get(arr[i]);
                val++;
                majELe.put(arr[i], val);
            }else{
                majELe.put(arr[i],1);
            }
        }
        int thrash = n/2;
        for(var maj: majELe.entrySet()){
            if(maj.getValue()>thrash){
                System.out.println(maj.getKey());
                break;
            }
        }
    }
}
