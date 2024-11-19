import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new LinkedList<>();
        for(int i =0; i<my_str.length(); i+=n){
            if(i + n <= my_str.length()){
                list.add(my_str.substring(i,i+n));    
            }else{
                list.add(my_str.substring(i));
            }
            
        }   
            
        String[] answer = new String[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}