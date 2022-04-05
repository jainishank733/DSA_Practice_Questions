package session_14;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramTwo {

    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        int n = str.length;
        Map<String, List<String>> map = new HashMap<>();
        for(String currString: str){
            int[] freq = new int[26];
            for(int i=0;i<currString.length();i++){
                char cc = currString.charAt(i);
                int index = cc - 'a';
                freq[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for(int e: freq){
                sb.append(e);
                sb.append("|");
            }
            String key = sb.toString();
            List<String> list;
            if(map.containsKey(key)) {
                list = map.get(key);
            }else{
                list = new ArrayList<>();
            }
            list.add(currString);
            map.put(key,list);
        }
        System.out.println(map.values());
    }
}
