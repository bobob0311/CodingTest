import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        int idx =2;
        while(n >1){
            if(n % idx == 0){
                set.add(idx);
                n/=idx;
                idx =2;
            }else{
                idx++;
            }
        }
        int[] answer = new int[set.size()];
        int i =0;
        for(int v : set){
            answer[i++] = v;
        }
        Arrays.sort(answer);
            
        
        return answer;
    }
}