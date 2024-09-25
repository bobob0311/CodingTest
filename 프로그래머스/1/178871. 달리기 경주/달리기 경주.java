import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] arr = new String[players.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<players.length; i++){
            arr[i] = players[i];
            map.put(players[i],i);
        }
        
        for(int i =0; i<callings.length; i++){
            int nowNum = map.get(callings[i]);
            arr[nowNum] = arr[nowNum-1];
            arr[nowNum-1] = callings[i];
            
            map.put(callings[i],nowNum-1);
            map.put(arr[nowNum], map.get(arr[nowNum])+1);
        }
        
        
        
        return arr;
    }
}