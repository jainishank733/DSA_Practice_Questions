package session_14;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> popMap = new HashMap<>();
        popMap.put("India", 20);
        popMap.put("USA",10);
        popMap.put("USA1",11);
        popMap.put("USA2",12);
        System.out.println(popMap.get("India"));
        System.out.println(popMap);
        System.out.println(popMap.containsKey("USA"));
        System.out.println(popMap.remove("USA"));
        for(var keyValuePair: popMap.entrySet()){
            System.out.println(keyValuePair.getKey()+" => "+keyValuePair.getValue());
        }
        for(String key: popMap.keySet()){
            System.out.println(key);
        }
        System.out.println(popMap.getOrDefault("Aus",8999));
        System.out.println(popMap.putIfAbsent("Rus",89));
    }
}
