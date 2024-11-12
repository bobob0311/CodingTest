import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new LinkedList<>();
        int s = (int) Math.sqrt(n);
        for(int i = 1; i<=(int) Math.sqrt(n); i++){
            if(n % i == 0){
                if( i == n/i ){
                    list.add(i);
                }else{
                    list.add(i);
                    list.add(n/i);    
                }
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