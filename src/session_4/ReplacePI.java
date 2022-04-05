package session_4;

public class ReplacePI {

    static void replacePI(String str, String ans){
        if(str.length()==0 || str.length()==1){
            System.out.println(ans+str);
            return;
        }
        if(str.charAt(0)=='p' && str.charAt(1)=='i') {
            replacePI(str.substring(2), ans + "3.14");
            return;
        }
        else{
            replacePI(str.substring(1),ans+str.charAt(0));
            return;
        }
    }

    public static void main(String[] args) {
        replacePI("abpipip","");
    }
}
