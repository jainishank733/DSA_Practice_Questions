package session_5;

public class All {

    static boolean isPalindrome(String str){
        int l=0, r=str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    static void partition(String inp, String out){
        if(inp.length()==0){
            System.out.println(out);
            return;
        }
        for(int i=1;i<=inp.length();i++){
            if(isPalindrome(inp.substring(0,i)))
                partition(inp.substring(i),out+inp.substring(0,i)+'|');
        }
    }

    public static void main(String[] args) {
        partition("nitin","");
    }
}
