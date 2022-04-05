package session_3;

public class GenAllPermutation {

    private static void gen(String inp, String ans){
        if(inp.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<inp.length();i++){
            char cc = inp.charAt(i);
            gen(inp.substring(0,i)+inp.substring(i+1),ans+cc);
        }
    }

    public static void main(String[] args) {
        gen("abc","");
    }
}
