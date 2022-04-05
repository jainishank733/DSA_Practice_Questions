package Session_1;

public class PrintInc {

    private static void inc(int n){
        // Base Condition
        if(n==0)
            return;
        // Recursive work
        inc(n-1);
        // my work
        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        inc(5);
    }
}
