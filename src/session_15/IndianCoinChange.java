package session_15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IndianCoinChange {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int amount = 39;
        int minCoins = 0;
        while(amount>0){
            int index = Arrays.binarySearch(arr, amount);
            if(index<0){
                index = Math.abs(index)-2;
            }
            amount-=arr[index];
            minCoins++;
        }
        System.out.println(minCoins);
    }
}
