import java.util.*;
class Solution {
    public String solution(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        
        for(int i = 0; i<s.length(); i++){
            String nowString = s.substring(i,i+1);
            if(map.get(nowString) == null){
                map.put(nowString,1);
            }else{
                map.put(nowString, map.get(nowString) + 1);
            }
        }
        
        for(String str : map.keySet()){
            if(map.get(str) == 1){
                list.add(str);
            }
        }
        Collections.sort(list);
        
        String answer = "";
        for(int i = 0; i<list.size(); i++){
            answer+=list.get(i);
        }
        
        return answer;
    }
}