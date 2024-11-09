/*
1. 한 명씩 신청한 순서대로 방배정
2. 원하는 방 제출
3. 비어있을시 즉시 배정
4. 이미 배정됭있을시 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방 배정

전에 있던 수들을 어떻게 저장할 것인가
Map?
Set?
List? => 이러면 너무 규모가 큰가?


*/
import java.util.*;
class Solution {
    public long[] solution(long k, long[] room_number) {
        Map<Long,Long> map = new HashMap<>();
        long[] answer = new long[room_number.length];
        
        int idx = 0;
        for(int i = 0; i<room_number.length; i++){
            long now = room_number[i];
            if(map.get(now) != null){
                // 찾아가야되는 인덱스
                long nextIdx = map.get(now);
                // 값 갱신
                while(true){
                    if(map.get(nextIdx)!=null){
                        map.put(now, map.get(nextIdx));
                        now = nextIdx;
                        nextIdx = map.get(nextIdx);
                    }else{
                        map.put(nextIdx,nextIdx+1);
                        answer[idx++] = nextIdx;
                        break;
                    }
                }
            }else{
                // 처음 들어왔으면 이제 이거 들어오면 여기로 가야돼~
                map.put(now,now+1);
                answer[idx++] = now;
            }
        }
        return answer;
    }
}