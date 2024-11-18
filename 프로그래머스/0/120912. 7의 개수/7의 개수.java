class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int v : array){
            while(v >0){
                if(v % 10 == 7){
                    answer++;
                }
                v/=10;
            }
        }
        
        
        return answer;
    }
}