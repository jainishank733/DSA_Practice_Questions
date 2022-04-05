package session_12;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {50, 31, 14, 35, 90};
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] nge = new int[n];
        for(int curr=1;curr<n;curr++){
            while (!st.isEmpty() && arr[st.peek()]<arr[curr]){
                nge[st.pop()] = arr[curr];
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            nge[st.pop()] = -1;
        }
        for(int ele=0;ele<n;ele++){
            System.out.println(arr[ele]+"=>"+nge[ele]);
        }
    }
}
