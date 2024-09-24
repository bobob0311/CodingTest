// 11 idx
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] day = today.split("\\.");

        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list= new LinkedList<>();
        
        int limit = calc(day);
        
        for(String term : terms){
            map.put(term.charAt(0), Integer.parseInt(term.substring(2)) * 28);
        }
        
        for(int i = 0; i<privacies.length; i++){
            String privacie = privacies[i];
            String tempStr =  privacie.substring(0,10);
            String[] nowday = tempStr.split("\\.");
            int days = calc(nowday) + map.get(privacie.charAt(11));

            if(days-1 < limit){
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = list.get(i) + 1;
        }
        

        return arr;
    }
    
    int calc(String[] day){
        return Integer.parseInt(day[0])*12*28 + (Integer.parseInt(day[1])-1) * 28 + Integer.parseInt(day[2])-1;
    }
}