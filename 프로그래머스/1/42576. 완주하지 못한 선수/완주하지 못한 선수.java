import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String part : participant){
            if(map.get(part) == null){
                map.put(part,1); 
            }else{
                map.put(part, map.get(part) +1);
            }
        }
        
        for(String comp : completion){
            if(map.get(comp) == 1){
                map.remove(comp);
            }else{
                map.put(comp, map.get(comp) -1);
            }
        }
        String answer ="";
        for(String people: map.keySet()){
            answer = people;
        }
        
        return answer;
    }
}