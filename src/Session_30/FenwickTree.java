package Session_30;

import java.util.Arrays;

public class FenwickTree {

    public static int sumQuery(int[] fenw, int i){
        int sum = 0;
        while(i>0){
            sum += fenw[i];
            int l =  intervalLength(i);
            i=i-l;
        }
        return sum;
    }

    public static void update(int[] fenw, int index, int val){
        while(index<fenw.length){
            fenw[index]+=val;
            int l = intervalLength(val);
            index = index+l;
        }
    }

    public static int intervalLength(int pos){
        return pos & -pos;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        int[] fenw = new int[12];

        for(int i = 1; i < arr.length; i++) {
            update(fenw, i, arr[i]);
        }

        System.out.println(sumQuery(fenw, 7));
        int l = 4, r = 7;

        int s17 = sumQuery(fenw, r);
        int s13 = sumQuery(fenw, l - 1);
        System.out.println(s17 - s13);
        System.out.println(Arrays.toString(fenw));

    }
}
