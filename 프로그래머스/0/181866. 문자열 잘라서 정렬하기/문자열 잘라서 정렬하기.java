import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] temp = myString.split("x");
        List<String> list = new LinkedList<>();
        for(String str : temp){
            if(!str.equals("")){
                list.add(str);
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}