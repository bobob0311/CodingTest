import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i<my_string.length(); i++){
            int ch = my_string.charAt(i);
            int num = (int) ch;
            if(num >= 48 && num<=57){
                list.add(Integer.parseInt(my_string.substring(i,i+1)));
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}