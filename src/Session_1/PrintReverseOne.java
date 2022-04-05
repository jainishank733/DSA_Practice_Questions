package Session_1;

public class PrintReverseOne {

    private static void reverse(int[] arr, int curr){
        if(curr == -1){
            return;
        }
        System.out.println(arr[curr]);
        reverse(arr,curr-1);
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,9};
        reverse(arr,3);
    }
}
