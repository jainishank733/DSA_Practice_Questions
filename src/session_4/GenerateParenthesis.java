package session_4;

public class GenerateParenthesis {

    static void genP(String ans, int oc, int cc, int n){
        if(oc==n && cc==n) {
            System.out.println(ans);
            return;
        }
        if(oc<n)
            genP(ans+'(',oc+1,cc,n);
        if(cc<oc)
            genP(ans+')',oc,cc+1,n);

    }

    public static void main(String[] args) {
        genP("",0,0,3);
    }
}
