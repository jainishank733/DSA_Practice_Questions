package session_15;

import java.util.*;

public class BusyMan {

    static class Pair{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return this.start+" "+this.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> activities = new ArrayList<>();
        while(n-- >0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            activities.add(new Pair(start, end));
        }
        System.out.println(activities.toString());
        Collections.sort(activities, new Comparator<Pair>() {
            @Override
            public int compare(Pair act1, Pair act2) {
                return act1.end-act2.end;
            }
        });
        int maxActivity = 1;
        int endTime = activities.get(0).end;
        for(int cur = 1; cur<activities.size();cur++){
            if(endTime<=activities.get(cur).start){
                maxActivity++;
                endTime = activities.get(cur).end;
            }
        }
        System.out.println(maxActivity);

    }
}
