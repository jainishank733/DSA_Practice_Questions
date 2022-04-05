package session_6;

public class LetterCombinations {

    static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static void sol(String inp, String out){
        if(inp.length()==0){
            System.out.println(out);
            return;
        }
        char currentDigitChar = inp.charAt(0);
        int currDigit = currentDigitChar - '0';
        String mappedString = mapping[currDigit];
        for(int i=0; i<mappedString.length();i++){
            sol(inp.substring(1),out+mappedString.charAt(i));
        }
    }

    public static void main(String[] args) {
        sol("23","");
    }

}
