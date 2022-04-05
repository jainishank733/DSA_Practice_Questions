package session_2;

public class ClimbingStairsTwo {

    private static int countStairs(int n){
        if(0 > n)
            return 0;
        if(0 == n)
            return 1;
        return countStairs(n-1)+countStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(countStairs(3));
    }
}
