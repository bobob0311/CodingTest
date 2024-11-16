class Solution {
    public int[][] solution(int[] num_list, int n) {
        int line = 0;
        int idx = 0;
        int[][] answer = new int[num_list.length/n][n];
        
        for(int i = 0; i<num_list.length; i++){
            if(i != 0 && i % n == 0){
                line++;
                idx = 0;
            }
            answer[line][idx++] = num_list[i];
            
            
        }
        

        return answer;
    }
}