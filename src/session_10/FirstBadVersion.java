package session_10;

public class FirstBadVersion {

    private static boolean utilIsBad(char c){
        return c == 'B';
    }

    static int findBadVersion(char[] version){
        int l=-1, r=version.length-1, mid;
        while(l+1<r){
            mid = (l+r)/2;
            if(utilIsBad(version[mid])){
                r=mid;
            }else{
                l=mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        char[] version = {'G','G','G','B','B'};
        System.out.println(findBadVersion(version));
    }
}
