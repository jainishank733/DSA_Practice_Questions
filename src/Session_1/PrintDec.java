package Session_1;

public class PrintDec {

    private static void dec(int n){
        // Base Condition
        if(n==0)
            return;
        // my work
        System.out.print(n+" ");
        // Recurrsive work
        dec(n-1);
    }

    public static void main(String[] args) {
        dec(5);
    }
}
