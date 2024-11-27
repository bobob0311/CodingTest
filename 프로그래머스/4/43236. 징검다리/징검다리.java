/*
출발지 distance만큼 떨어져있다. 
바위 몇개를 지울 수 있다. 
거리의 최솟값중에 가장 큰 값을 찾아라.

제거할 돌을 선정을 어떻게 해야될까?
이게 제거하면서 하면 안될거같은데.

*/
import java.util.*;
class Solution {
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        
        int answer = 0;
        
        while(start <= end){
            int mid = (start+end) / 2;
            int cnt = 0;
            int prevRock = 0;
            
            for(int rock : rocks){
                if((rock - prevRock) < mid){
                    cnt++;
                } else{
                    prevRock = rock;
                }
            }
            
            if(distance - prevRock < mid){
                cnt++;
            }
            
            if(cnt > n){
                end = mid -1;
            }else if(cnt <= n){
                start = mid + 1;
                answer = mid;
            }
            
        }
        
        return answer;
    }
}