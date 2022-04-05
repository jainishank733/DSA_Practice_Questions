package session_4;

public class MaizePathTwoDirection {

    static int count;
    static void maizePathPrint(int cr, int cc, int er, int ec, String path){
        if(cr>er || cc>ec)
            return;
        if(cr==er && cc==ec){
            System.out.println(path);
            return;
        }
        maizePathPrint(cr+1, cc, er, ec, path+'R');
        maizePathPrint(cr, cc+1, er, ec, path+'D');

    }

    static int maizePathCount(int cr, int cc, int er, int ec, String path){
        if(cr>er || cc>ec)
            return 0;
        if(cr==er && cc==ec){
            count++;
            return 1;
        }

        int a = maizePathCount(cr+1, cc, er, ec, path+'R');
        int b = maizePathCount(cr, cc+1, er, ec, path+'D');
        return a+b;

    }

    public static void main(String[] args) {
        maizePathPrint(0,0,2,2,"");
        System.out.println(maizePathCount(0,0,2,2,""));

    }
}
