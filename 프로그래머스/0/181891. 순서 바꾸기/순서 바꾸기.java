class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        for(int i = 0; i<num_list.length; i++){
            int idx = i + n;
            if(idx >= num_list.length){
                idx -= num_list.length;
            }
            answer[i] = num_list[idx];
        }
        return answer;
    }
}