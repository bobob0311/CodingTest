class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        
        for(int i = 0; i<= Math.min(k,board.length-1); i++){
            for(int j = 0; j<=Math.min(k-i, board[i].length-1); j++){
                answer+= board[i][j];
            }
        }
        
        
        return answer;
    }
}