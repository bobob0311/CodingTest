class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int c = chicken;
        while(c >= 10){
            answer += c /10;
            c = (c % 10) + c/10;
            
        }
        
        return answer;
    }
}