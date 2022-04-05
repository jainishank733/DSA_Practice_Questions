package session_5;

public class MaizeFourDirection {

    static void maizePath(int[][] maze, int cr,int cc, int er, int ec, String path, boolean[][] vis){
        if(cr==er && cc==ec){
            System.out.println(path);
            return;
        }
        if(cr<0 || cc<0 || cr>er || cc>ec || vis[cr][cc] || maze[cr][cc] == 1)
            return;
        vis[cr][cc]=true;
        maizePath(maze,cr+1,cc,er,ec,path+'D',vis);
        maizePath(maze,cr-1,cc,er,ec,path+'U',vis);
        maizePath(maze, cr,cc+1,er,ec,path+'R',vis);
        maizePath(maze, cr,cc-1,er,ec,path+'L',vis);
        vis[cr][cc]=false;
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] maze = {{0,1,0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1,1, 0}};
        maizePath(maze,0, 0, n - 1, m - 1, "", new boolean[n][m]);
    }
}
