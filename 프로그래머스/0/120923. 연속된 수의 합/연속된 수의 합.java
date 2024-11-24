class Solution {
    public int[] solution(int num, int total) {
        int end = 1000;
        
        while(true){
            int target =0;
            for(int i = end; i>end-num; i--){
                target+= i;
            }
            if(target == total){
                break;
            }else{
                end--;
            }
        }
        
        int[] answer = new int[num];
        int idx = num-1;
        for(int i = end ; i>= end-num+1; i--){
            answer[idx--] = i;
        }
        
        
        return answer;
    }
}