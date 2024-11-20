class Solution {
    public int solution(int[] sides) {
        int cnt = 0;
        int max = Math.max(sides[0],sides[1]);
        int min = Math.min(sides[0],sides[1]);
        
        // 가장 긴변이 지금 생기는 경우
        int now = max;
        while(true){
            if(now <sides[0] + sides[1]){
                cnt++;
            }else{
                break;
            }
            now++;
        }
        // 가장 긴변이 이미 있는 경우 
        now = max-1;
        while(now != 0){
            if(max < now + min){
                cnt++;
            }else{
                break;
            }
            now--;
        }
        

        return cnt;
    }
}