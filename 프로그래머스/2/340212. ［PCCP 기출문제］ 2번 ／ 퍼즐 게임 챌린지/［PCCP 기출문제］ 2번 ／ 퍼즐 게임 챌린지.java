/*
8:30 

diff => 난이도
time_cur => 현재 퍼즐 소요시간
time_prev => 이전 퍼즐 소요 시간
level => 숙련도
*/

/*
1. diff <= level 
    퍼즐 틀리지않고 time_cure 만크믜 시간을 사용하여 해결
2. diff > level
    퍼즐을 총 diff-level 번틀림 
    => 틀릴 때마다 time_cur 만큼 시간을 사용 추가로 time_prev 만큼의 시간 사용 이전 퍼즐 다시 풀기
    => 이전 퍼즐을 풀 때는 난이도에 상관 없이 ㅌㄹ리지 않음
    diff-level 번 틀리면 time_cur만큼 사용하여 퍼즐 해결
    
    
제한 시간 내에 펒ㄹ을 모두 해결하기 위한 숙련도의 최솟값을 정수로 return 

100000~~~ 이거 이분 탐색?
*/

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start = 0;
        int end = 100000;
        int mid=0;

        
        while(start < end){
            int pre = 0;
            long time = 0;
            
            mid = (start + end) / 2;
            for(int i =0; i<diffs.length; i++){
                int diff = diffs[i];

                if(diff <= mid){
                    time += times[i];
                }else{
                    time += (diff-mid) * (times[i] + pre) + times[i];
                }
                pre = times[i];
            }
            if(time<=limit){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        if(start == 0){
            return 1;
        }
        
        return start;
    }
}