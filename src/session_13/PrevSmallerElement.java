package session_13;

import java.util.Stack;

public class PrevSmallerElement {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3};
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        pse[0] = -1;
        for(int cur=1; cur<n; cur++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[cur]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[cur] = st.peek();
            }else{
                pse[cur] = -1;
            }
            st.push(cur);
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" => "+pse[i]);
        }
    }
}
