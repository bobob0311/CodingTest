/*
일렬로 나열된 n개의 집에 택배를 배달
배달하면서 빈 재활용 택배 상자 수거 
i 번째 집은 물류 창고에서 거리가 i
i번째 지븐 j번 째 집과 j-i떨어짐

cap => 최대 실을 수 있는 개 수
하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리 구하기 


cap => 최대 실을 수 있는 개수 
n => 배달할 집이 개수 
deliveries => 배달할 재활용 택배 상자 
pickups => 수거할 상자의 개수 

아 털고 수거 털고 수거 느낌

100000

50
50
*/
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int length =0;
        int c1 = 0;
        int c2 = 0;
        for(int i =0; i<deliveries.length; i++){
            c1+=deliveries[i];
        }
        for(int i =0; i<pickups.length; i++){
            c2+=pickups[i];
        }
        length = (Math.max(c1,c2))/cap +1;
        
        List<Integer> list1 = new ArrayList<>(length);
        List<Integer> list2 = new ArrayList<>(length);
        int idx = n-1;
        int v = 0;
        while(idx>=0){
            if(deliveries[idx] == 0){
                idx--;
                continue;
            }
            v += deliveries[idx];
            while(v > 0){
                v -= cap;
                list1.add(idx+1);
            }
            idx--;
        }
        
        idx = n-1;
        v = 0;
        while(idx>=0){
            if(pickups[idx] == 0){
                idx--;
                continue;
            }
            v += pickups[idx];
            while(v > 0){
                v -= cap;
                list2.add(idx+1);
            }
            idx--;
        }
        long answer = 0;
        
        int minIdx = Math.min(list1.size(), list2.size());
        
        for(int i =0; i<minIdx; i++){
            int far =0;
            int temp1 = list1.get(i);
            int temp2 = list2.get(i);
            answer+= Math.max(temp1,temp2);    
        }
        
        if(list1.size() > minIdx){
            for(int i =minIdx; i<list1.size(); i++){
                answer+=list1.get(i);
            }
        }else if (list2.size() > minIdx){
            for(int i =minIdx; i<list2.size(); i++){
                answer+=list2.get(i);
            }
        }
        

        return answer*2;
    }
}