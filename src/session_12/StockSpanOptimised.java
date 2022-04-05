package session_12;

import java.util.Stack;

public class StockSpanOptimised {


    public static void main(String[] args) {
        int[] arr = {50,10,20,30,40,35 };
        int n = arr.length;
        int[] span = new int[n];
        span[0] = 1;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for(int cur=1;cur<n;cur++){
            while(!st.isEmpty() && arr[st.peek()]<arr[cur]){
                st.pop();
            }
            span[cur] = st.isEmpty() ? cur+1: cur-st.peek();
            st.push(cur);
        }
        for(int i=0;i<n;i++){
            System.out.print(span[i]+" ");
        }
    }
}
