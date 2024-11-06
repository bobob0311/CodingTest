import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        List<String> list = new LinkedList<>();
        
        String tempStr = my_string.trim();
        String[] tempArr = tempStr.split(" ",0);
        for(int i = 0; i<tempArr.length; i++){
            if(!tempArr[i].equals("")){
                list.add(tempArr[i]);
            }
        }
        String[] answer = new String[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i]= list.get(i);
        }
        
        return answer;
    }
}