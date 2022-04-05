package Session_1;

public class Factorial {

    private static int fact(int n){
        if(n==1 || n==0)
            return 1;
        return n*fact(n-1);
    }

    private static void fact(int n, int ans){
        if(n==0 || n==1) {
            System.out.println("Factorial Answer: " + ans);
            return;
        }
        fact(n-1, ans*n);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        fact(5,1);
    }
}
