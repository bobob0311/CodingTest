class Solution {
    public int solution(int[] numbers, int k) {
        int cnt = 0;
        int len = numbers.length;
        int now = 0;
        
        while(cnt != k-1){
            if(now + 2 >= len){
                now = (now+2) - len;
            }else{
                now += 2;
            }
            cnt++;
        }
        
        return now+1;
    }
}