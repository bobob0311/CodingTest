class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for(int i = 0; i<control.length(); i++){
            char now = control.charAt(i);
            
            
            if(now == 'w'){
                answer++;
            }else if(now == 's'){
                answer--;
            }else if(now == 'd'){
                answer+=10;
            }else{
                answer-=10;
            }
        }
        return answer+n;
    }
}