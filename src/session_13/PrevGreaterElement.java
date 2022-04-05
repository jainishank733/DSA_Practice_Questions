package session_13;

import java.util.Stack;

public class PrevGreaterElement {

    public static void main(String[] args) {
        int[] arr = {31, 14, 22, 20, 50};
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        pge[0] = -1;
        for(int cur=1; cur<n; cur++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[cur]){
                st.pop();
            }
            if(!st.isEmpty()){
                pge[cur] = st.peek();
            }else{
                pge[cur] = -1;
            }
            st.push(cur);
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" => "+pge[i]);
        }
    }
}
