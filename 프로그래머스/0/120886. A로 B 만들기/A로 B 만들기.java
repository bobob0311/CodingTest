import java.util.*;
class Solution {
    public int solution(String before, String after) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for(int i = 0; i<before.length(); i++){
            String nowStr = before.substring(i,i+1);
            if(map1.get(nowStr) != null){
                map1.put(nowStr, map1.get(nowStr) + 1);
            }else{
                map1.put(nowStr, 1);
            }
        }
        
        for(int i = 0; i<after.length(); i++){
            String nowStr = after.substring(i,i+1);
            if(map2.get(nowStr) != null){
                map2.put(nowStr, map2.get(nowStr) + 1);
            }else{
                map2.put(nowStr, 1);
            }
        }        
        for(String v : map1.keySet()){
            if(map1.get(v) != map2.get(v)){
                return 0;
            }
        }
        return 1;
    }
}