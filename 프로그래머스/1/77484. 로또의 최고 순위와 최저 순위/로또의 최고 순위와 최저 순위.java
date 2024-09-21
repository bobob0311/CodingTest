

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int Acnt = 0 ;
        
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0){
                cnt++;
            }
        }
        
        for(int i = 0; i<lottos.length; i++){
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    Acnt++;
                    break;
                }
            }
        }
        int[] answer = {Acnt + cnt, Acnt};
        for(int i =0; i<2; i++){
            if(answer[i] >=2){
                answer[i] = 7- answer[i];
            }else{
                answer[i] = 6;
        }    
        }
        
        
        return answer;
    }
}