package session_12;

import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3};
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] nse = new int[n];
        for(int curr=1;curr<n;curr++){
            while (!st.isEmpty() && arr[st.peek()]>arr[curr]){
                nse[st.pop()] = arr[curr];
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            nse[st.pop()] = -1;
        }
        for(int ele=0;ele<n;ele++){
            System.out.println(arr[ele]+"=>"+nse[ele]);
        }
    }
}
