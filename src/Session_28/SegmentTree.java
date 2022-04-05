package Session_28;

import java.util.Arrays;

public class SegmentTree {

    public static void build(int[] arr, int l, int r, int[] segTree, int ci){
        if(l == r){
            segTree[ci] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(arr, l, mid, segTree, 2*ci);
        build(arr, mid+1, r, segTree, 2*ci+1);
        segTree[ci] = Math.min(segTree[2*ci], segTree[2*ci + 1]);
    }

    public static void updatePoint(int[] arr, int l, int r, int[] segTree, int ci, int updInd){
        if(l == r){
            segTree[ci] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        if(updInd<=mid){
            build(arr, l, mid, segTree, 2*ci);
        }else{
            build(arr, mid+1, r, segTree, 2*ci+1);
        }
        segTree[ci] = Math.min(segTree[2*ci], segTree[2*ci + 1]);
    }

    public static int minQuery(int[] segTree, int cl, int cr, int ql, int qr, int ci){
        if(cr<ql || cl>qr){
            return Integer.MAX_VALUE;
        }
        if(cl>=ql && cr<=qr){
            return segTree[ci];
        }
        int mid = (cl+cr)/2;
        int leftMin = minQuery(segTree, cl, mid, ql, qr,2*ci);
        int rightMin = minQuery(segTree, mid+1, cr, ql, qr,2*ci+1);
        return Math.min(leftMin,rightMin);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, -3, 4, -1};
        int n = arr.length;

        int[] segTree = new int[4*n];
        build(arr, 0, n-1, segTree, 1);
        System.out.println(Arrays.toString(segTree));

        System.out.println(minQuery(segTree, 0, n-1, 0, 2, 1));

        arr[3] = 5;
        updatePoint(arr, 0, n - 1, segTree, 1, 3);
        System.out.println(Arrays.toString(segTree));

    }
}
