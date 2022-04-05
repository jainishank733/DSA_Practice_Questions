package session_4;

public class LexicoCounting {

    static void lexicoCounting(int start, int end){
        if(start>end){
            return;
        }
        System.out.println(start+" ");
        int callDigit = 0;
        if(start == 0)
            callDigit = 1;
        while (callDigit<=9){
            lexicoCounting(start*10+callDigit,end);
            callDigit++;
        }
    }

    public static void main(String[] args) {
        lexicoCounting(0,10);
    }
}
