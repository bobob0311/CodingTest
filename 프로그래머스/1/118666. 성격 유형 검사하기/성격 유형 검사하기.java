import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        String[] c = new String[] {"R","T","C","F","J","M","A","N"};
        
        for(String v : c){
            map.put(v,0);
        }
        int idx = 0;
        
        for(String nowSurvey : survey){
            String front = String.valueOf(nowSurvey.charAt(0));
            String back = String.valueOf(nowSurvey.charAt(1));
            
            int cho = choices[idx++];
            
            String target;
            if(cho<4){
                target = front;
                if(cho == 1){
                    map.put(target, map.get(target)+3);
                }else if(cho == 2){
                    map.put(target, map.get(target)+2);
                }else{
                    map.put(target, map.get(target)+1);
                }
            }else if(cho > 4){
                target = back;
                if(cho == 5){
                    map.put(target, map.get(target) + 1);
                }else if(cho == 6){
                    map.put(target, map.get(target) + 2);
                }else {
                    map.put(target, map.get(target) + 3);
                }
            }
        }
        String answer ="";
        
        for(int i = 0; i< 8 ; i+=2){
            if(map.get(c[i]) < map.get(c[i+1])){
                answer += c[i+1];
            }else{
                answer+= c[i];
            }
        }

        return answer;
    }
}