class Solution {
    public int[] solution(int[] num_list) {
        int cnt = 0;
        for(int i =0; i< num_list.length; i++){
            if(num_list[i] % 2 == 0){
                cnt++;
            }
        }
        
        int[] answer = {cnt, num_list.length-cnt};
        return answer;
    }
}