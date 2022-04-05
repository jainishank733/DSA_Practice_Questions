package session_12;

public class StockSpanBrute {

    public static void main(String[] args) {
        int[] arr = {50, 20, 30, 40, 10};
        int n = arr.length;
        int[] span = new int[n];
        span[0]=1;
        for(int i=1;i<span.length;i++){
            span[i]=1;
            for(int left=i-1;left>=0;left--){
                if(arr[i]>arr[left]){
                    span[i]++;
                }else{
                    break;
                }
            }
        }
        for(int e: span){
            System.out.println(e+" ");
        }
    }
}
