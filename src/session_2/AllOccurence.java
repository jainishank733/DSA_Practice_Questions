package session_2;

public class AllOccurence {

    private static int[] sol(int[] arr, int curr, int search, int n, int count){
        if(curr == n){
            int[] ans = new int[count];
            return ans;
        }
        if(arr[curr] == search){
            int[] recA = sol(arr, curr+1, search, n, count+1);
            recA[count] = curr;
            return recA;
        }
        else{
            int[] recA = sol(arr, curr+1,search, n, count);
            return recA;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,14,2,4};
        int[] rec = sol(arr, 0, 2, arr.length, 0);
        for(int i: rec)
            System.out.print(i+" ");
    }
}
