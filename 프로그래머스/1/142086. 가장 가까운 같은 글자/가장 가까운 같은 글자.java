import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int[] arr = new int[s.length()]; 
        
        for(int i =0; i<s.length(); i++){
            Character nowChar = s.charAt(i);
            if(map.get(nowChar) == null){
                arr[i] = -1;
                map.put(nowChar,i);
            }else{
                int pre = map.get(nowChar);
                arr[i] = i - pre;
                map.put(nowChar,i);
            }
        }

        return arr;
    }
}