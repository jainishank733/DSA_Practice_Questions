package session_13;

import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] nse = new int[n];
        for(int cur=1;cur<n;cur++){
            while(!st.isEmpty() && arr[st.peek()]>arr[cur]){
                nse[st.pop()] = cur;
            }
            st.push(cur);
        }
        while(!st.isEmpty()){
            nse[st.pop()]=n;
        }
        int[] pse = new int[n];
        st.push(0);
        pse[0]=-1;
        for(int cur=1;cur<n;cur++){
            while (!st.isEmpty() && arr[cur]<=arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[cur] = st.peek();
            }
            else{
                pse[cur] = -1;
            }
            st.push(cur);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            int area = width*arr[i];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }

}
