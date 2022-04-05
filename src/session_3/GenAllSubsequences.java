package session_3;


public class GenAllSubsequences {

    private static void gen(String inp, String ans){
        if(inp.length() == 0){
            System.out.println("Subsequence: "+ans);
            return;
        }
        char cc = inp.charAt(0);
        gen(inp.substring(1),ans+cc);
        gen(inp.substring(1),ans);
    }

    public static void main(String[] args){
        gen("abc","");
    }
}
