class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        int answer = 0;
        if(len>10){
            for(int i =0; i<len; i++){
                answer += num_list[i];
            }
        }else{
            answer = 1;
            for(int i =0; i<len; i++){
                answer *= num_list[i];
            }
        }
        return answer;
    }
}