class Solution {
    public int solution(int n) {
        int cnt = 0;
        for(int i =1; i<=Math.sqrt(n); i++){
            if(i*i == n){
                cnt++;
                continue;
            }
            if(n%i ==0){
                cnt+=2;
            }
        }
        
        return cnt;
    }
}