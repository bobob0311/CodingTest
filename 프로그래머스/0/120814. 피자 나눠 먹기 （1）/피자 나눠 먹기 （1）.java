class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while(true){
            if((7 * answer) >= n){
                return answer;
            }
            answer++;
        }
    }
}