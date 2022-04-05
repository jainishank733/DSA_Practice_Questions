package session_32;

public class FormBiggestNumber {

    private static int compare(int curr, int curr_1) {
        String xy = curr + "" + curr_1;
        String yx = curr_1 + "" + curr;

        int vxy = Integer.valueOf(xy);
        int vyx = Integer.valueOf(yx);
        if(vxy > vyx) {
            return -1;
        } else {
            return 1;
        }

    }
    public static void main(String[] args) {

        int[] arr = {54, 546, 548, 60};
        int n = arr.length;

        for(int cp = 1; cp <= n - 1; cp++) {

            for(int curr = 0; curr <= n - cp - 1; curr++) {

                if(compare(arr[curr], arr[curr + 1]) > 0) {
                    int temp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }

}