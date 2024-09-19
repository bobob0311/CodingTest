class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            int p = n / a;
            int getBottle = p * b;
            n = n - p* (a - b);
            answer += getBottle;
        }

        
        return answer;
    }
}