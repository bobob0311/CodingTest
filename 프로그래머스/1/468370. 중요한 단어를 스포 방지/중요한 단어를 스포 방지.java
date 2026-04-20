import java.util.*;

class Solution {
    static HashMap<String,Integer> hidden = new HashMap<>();
    static HashMap<String,Integer> map = new HashMap<>();
    
    public int solution(String message, int[][] spoiler_ranges) {
        hidden.clear();
        map.clear();
        
        for(String str : message.split(" ")){
            addStr(str);
        }
        
        findHiddenStr(spoiler_ranges,message);
        
        for(String hiddenStr : hidden.keySet()){
            System.out.print(hiddenStr+" ");
        }
        System.out.println();
        
        for(String str : map.keySet()){
            System.out.print(str+" ");
        }
        
        for(String hiddenStr : hidden.keySet()){
            map.put(hiddenStr, map.get(hiddenStr) - hidden.get(hiddenStr));
        }
        
        int answer = 0;
        for(String str: map.keySet()){
            if(map.get(str) == 0) answer++;
        }
        
        return answer;
    }
    
    static void findHiddenStr(int[][] spoiler_ranges, String message){
        int prevEnd = -1;
        for(int[] spoiler : spoiler_ranges){
            
            int start = spoiler[0];
            int end = spoiler[1];
            
            if(prevEnd +1 > message.length() -1) continue;
            
            if(prevEnd >= start) start = prevEnd+1;
            
            if(prevEnd >= end || start > end) continue;
            
            while(start >=0 && message.charAt(start) != ' '){
                start--;
            }
            
            while( end <message.length() && message.charAt(end) != ' '){
                end++;
            }
            prevEnd = end-1;
            
            if(start +1 >=end) continue;
            String[] spoilerStr = message.substring(start+1,end).trim().split(" ");
            
            for(String sp: spoilerStr){
               addHiddenStr(sp);
            }
        }
    }
    
    
    static void addHiddenStr(String str){
        if(hidden.get(str) != null){
            hidden.put(str,hidden.get(str) + 1);
        }else{
            hidden.put(str,1);
        }
    }
    
    static void addStr(String str){
        if(map.get(str) != null){
            map.put(str,map.get(str) + 1);
        }else{
            map.put(str,1);
        }
    }
}