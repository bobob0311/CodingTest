import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        int idx = 0;
        for(int i = my_string.length()-1; i>=0; i--){
            String tempStr =  my_string.substring(i);
            answer[idx++] = tempStr;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}