class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i =left; i<=right ; i++){
            int v = (int) Math.sqrt(i);
            if(v*v == i){
                answer-=i;
            }else{
                answer+=i;
            }
        }
        
        return answer;
    }
}