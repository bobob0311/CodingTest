/*
1912 시작
*/
import java.util.*;


class Solution {

    static int answer = Integer.MAX_VALUE;
    static HashMap<Integer,Integer> map = new HashMap<>();
    
    public int solution(int[][] cost, int[][] hint) {
        initMap(cost.length);
        int maxHintLength = cost[0].length-1;
        dfs(0,0,cost,hint,maxHintLength);
        
        return answer;
    }
    
    static void dfs(int step, int val,int[][] cost, int[][] hint,int maxHintLength){
        if(step == cost.length) {
            answer = Math.min(answer, val);
            return;
        }
        
        if(step == cost.length -1){
            dfs(step +1, val + cost[step][Math.min(map.get(step),maxHintLength)],cost,hint,maxHintLength);
        }else{
            int hintCnt = Math.min(map.get(step), maxHintLength);
            int currentVal = val + cost[step][hintCnt];

            int hintCost = buyHint(hint[step]);
            dfs(step+1,currentVal + hintCost,cost,hint,maxHintLength);

            deleteHint(hint[step]);
            dfs(step+1,currentVal,cost,hint,maxHintLength);
        }
    }
    static void initMap(int n){
        for(int i = 0; i<=n ; i++){
            map.put(i,0);
        }
    }
    
    static int buyHint(int[] hint){
        for(int i = 1; i<hint.length; i++){
            addHint(hint[i]-1);
        }
        return hint[0];
    }
    
    static void deleteHint(int[] hint){
        for(int i = 1; i<hint.length; i++){
            removeHint(hint[i]-1);
        }
    }
    
    static void addHint(int hintIdx){
        map.put(hintIdx,map.get(hintIdx) +1);
    }
    static void removeHint(int hintIdx){
        map.put(hintIdx,map.get(hintIdx) -1);
    }
}