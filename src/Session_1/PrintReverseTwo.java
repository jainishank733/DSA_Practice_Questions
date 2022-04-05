package Session_1;

public class PrintReverseTwo {

    private static void reverse(int[] arr, int curr, int n){
        if(curr == n){
            return;
        }
        reverse(arr,curr+1,n);
        System.out.println(arr[curr]);
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,9};
        reverse(arr,0,arr.length);
    }
}
