/*
1. 두 사람 사이에 더 많은 선물을 준 사람이 다음달에 선물을 받는다.

2. 기록이 없거나 주고 받은 수가 같다면 선물 지수가 더 큰사람이 선물 지수가 더 작은 사람에게 받는다. 
    - 선물 지수 => 자신이 친구들에게 준 선물의 수 - 받은 선물의 수 
    
3. 선물 지수도 같다면 다음 달에 선물을 주고 받지 않는다.
*/

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물 지수를 담을 Map
        Map<String,Integer> people = new HashMap<>();
        Map<String,Integer> point = new HashMap<>();
        
        int[][] arr = new int[friends.length][friends.length];
        
        for(int i =0; i<friends.length; i++){
            String friend = friends[i];
            people.put(friend,i);
            point.put(friend,0);
        }
        
        int[] answer = new int[friends.length];
        
        for(String gift :gifts){
            String[] strArr = gift.split(" ");
            String g = strArr[0];
            String r = strArr[1];
            
            arr[people.get(g)][people.get(r)]++;
            
            point.put(g, point.get(g)+1);
            point.put(r, point.get(r)-1);
        }
        
        for(int i =0; i < friends.length; i++){
            for(int j = i+1; j<friends.length; j++){
                if(arr[i][j] > arr[j][i]){
                    answer[i]++;
                }else if(arr[i][j] < arr[j][i]){
                    answer[j]++;
                }else{
                    if(point.get(friends[i]) > point.get(friends[j])){
                        answer[i]++;
                    }else if(point.get(friends[i]) < point.get(friends[j])){
                        answer[j]++;
                    }
                }
            }
        }
        int max = 0;
        for(int v : answer){
            max = Math.max(max,v);
        }
        
        
        return max;
    }
}