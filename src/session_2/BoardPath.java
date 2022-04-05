package session_2;

public class BoardPath {

    private static int countStairs(int curr, int n){
        if(curr > n)
            return 0;
        if(curr == n)
            return 1;
        return countStairs(curr+1,n)+countStairs(curr+2,n)+countStairs(curr+3,n)+countStairs(curr+4,n)+countStairs(curr+5,n)+countStairs(curr+6,n);
    }

    public static void main(String[] args) {

        System.out.println(countStairs(0,10));
    }
}
