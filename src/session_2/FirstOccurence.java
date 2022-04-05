package session_2;

public class FirstOccurence {

    private static int sol(int[] arr, int curr, int n, int search){
        if(curr==n)
            return -1;
        if(arr[curr]==search)
            return curr;
        return sol(arr,curr+1,n,search);
    }

    public static void main(String[] args) {
        int[] arr = {34,6,2,15,7,2};
        System.out.println(sol(arr,0,6,2));
    }
}
