import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        for(String card : cards1){
            que1.add(card);
        }
        for(String card : cards2){
            que2.add(card);
        }
        int idx = 0;
        while(idx < goal.length){
            if(que1.peek() != null &&que1.peek().equals(goal[idx])){
                que1.poll();
                idx++;
                continue;
            }else if(que2.peek() != null && que2.peek().equals(goal[idx])){
                que2.poll();
                idx++;
                continue;
            }else{
                return "No";
            }
        }
        
        if(idx == goal.length){
            return "Yes";
        }
        return "";
    }
}