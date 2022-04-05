package session_14;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        int n = str.length;
        Map<String, List<String>> map = new HashMap<>();
        for(String currString: str){
            char[] currStringArray = currString.toCharArray();
            Arrays.sort(currStringArray);
            String sortedStringKey = new String(currStringArray);
            List<String> list;
            if(map.containsKey(sortedStringKey)) {
                list = map.get(sortedStringKey);
            }else{
                list = new ArrayList<>();
            }
            list.add(currString);
            map.put(sortedStringKey,list);
        }
        System.out.println(map.values());
        //List<List<String>> ans = new ArrayList<>(map.values());


    }
}
