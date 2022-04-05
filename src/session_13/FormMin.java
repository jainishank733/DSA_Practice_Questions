package session_13;

import java.util.Stack;

public class FormMin {

    public static void main(String[] args) {
        String s = "IDIIIIDD";
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=s.length();i++){
            st.push(i+1);
            if(i==s.length() || s.charAt(i)=='I'){
                while (!st.isEmpty()){
                    System.out.print(st.pop());
                }
            }
        }
    }
}
