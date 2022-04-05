package session_2;

public class ClimbingStairs {

    private static int countStairs(int curr, int n){
        if(curr > n)
            return 0;
        if(curr == n)
            return 1;
        return countStairs(curr+1,n)+countStairs(curr+2,n);
    }

    public static void main(String[] args) {
        System.out.println(countStairs(0,3));
    }
}
