package Session_29;

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

    public static void rangeUpdate(int[] segTree, int[] lazy, int ul, int ur, int cl, int cr, int value, int ci){
        if(lazy[ci]!=0){
            segTree[ci]+=lazy[ci];
            if(cl!=cr){
                lazy[2*ci] += lazy[ci];
                lazy[2*ci+1] += lazy[ci];
            }
            lazy[ci] = 0;
        }
        if(cr<ul || cl>ur){
            return;
        }
        if(cl>=ul && cr<=ur){
            segTree[ci]+=value;
            if(cl!=cr){
                lazy[2*ci]+=value;
                lazy[2*ci+1]+=value;
            }
            return;
        }
        int mid = (cl+cr)/2;
        rangeUpdate(segTree, lazy, ul, ur, cl, mid, value, 2*ci);
        rangeUpdate(segTree, lazy, ul, ur, mid+1, cr, value, 2*ci+1);
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

    private static int minQuery(int[] segTree, int cl, int cr, int ql, int qr, int ci, int[] lazy) {

        if (lazy[ci] != 0) {

            segTree[ci] += lazy[ci];
            if (cl != cr) {
                lazy[2 * ci] += lazy[ci];
                lazy[2 * ci + 1] += lazy[ci];
            }

            lazy[ci] = 0;
        }

        if (cr < ql || cl > qr) {
            return Integer.MAX_VALUE;
        }

        if (cl >= ql && cr <= qr) {
            return segTree[ci];
        }

        int mid = (cl + cr) / 2;
        int leftMin = minQuery(segTree, cl, mid, ql, qr, 2 * ci, lazy);
        int rightMin = minQuery(segTree, mid + 1, cr, ql, qr, 2 * ci + 1, lazy);

        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, -3, 4, -1};
        int n = arr.length;

        int[] segTree = new int[4*n];
        int[] lazy = new int[4*n];

        build(arr, 0, n-1, segTree, 1);
        System.out.println(Arrays.toString(segTree));


        arr[3] = 5;
        updatePoint(arr, 0, n - 1, segTree, 1, 3);
        System.out.println(Arrays.toString(segTree));

        System.out.println("****************************");
        rangeUpdate(segTree, lazy, 0, 3, 0, n - 1, 3, 1);
        System.out.println(Arrays.toString(segTree));
        System.out.println(Arrays.toString(lazy));

        System.out.println("****************************");
        rangeUpdate(segTree, lazy, 0, 3, 0, n - 1, 1, 1);
        System.out.println(Arrays.toString(segTree));
        System.out.println(Arrays.toString(lazy));

        System.out.println("****************************");
        rangeUpdate(segTree, lazy, 0, 0, 0, n - 1, 2, 1);
        System.out.println(Arrays.toString(segTree));
        System.out.println(Arrays.toString(lazy));

        System.out.println("****************************");
        System.out.println(minQuery(segTree, 0, n - 1, 3, 5, 1, lazy));
        System.out.println(Arrays.toString(segTree));
        System.out.println(Arrays.toString(lazy));

    }
}
