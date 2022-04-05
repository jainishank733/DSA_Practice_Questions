package session_6;


public class NQueen {

    static int count;

    static boolean canPlaced(int[][] board, int cr, int cc, int n){
        for(int row=0;row<=cr-1;row++){
            if(board[row][cc]==1)
                return false;
        }
        int row = cr;
        int col = cc;
        while (row>=0 && col<n){
            if(board[row][col]==1)
                return false;
            row--;
            col++;
        }
        row = cr;
        col = cc;
        while (row>=0 && col>=0){
            if(board[row][col]==1)
                return false;
            row--;
            col--;
        }
        return true;
    }

    static void sol(int[][] board, int n, int cr){
        if(cr==n){
            count++;
            return;
        }
        for (int cc = 0; cc<n; cc++){
            if(canPlaced(board, cr, cc, n)){
                board[cr][cc] = 1;
                sol(board,n,cr+1);
                board[cr][cc] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {

        int[][] board = new int[4][4];
        sol(board,4,0);
        System.out.println(count);
    }
}
