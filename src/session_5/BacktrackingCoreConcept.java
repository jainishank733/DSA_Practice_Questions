package session_5;

public class BacktrackingCoreConcept {

    static void gharDestroy(boolean[] arr, int i){
        if(i==arr.length){
            return;
        }
        arr[i] = true;
        gharDestroy(arr, i+1);
        arr[i] = false;
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[4];
        for(boolean a: arr)
            System.out.print(a+" ");

        System.out.println();

        gharDestroy(arr,0);
        for(boolean a: arr)
            System.out.print(a+" ");


    }
}
