class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int solution(String[][] board, int h, int w) {
        int length = board.length;
        String target = board[h][w];
        int count =0; 
        for(int i=0;i<4;i++){
            int nextX = h+dx[i];
            int nextY = w+dy[i];
            if(nextX <length && nextX>=0 && nextY <length && nextY>=0){
                if(board[nextX][nextY].equals(target)){
                    count++;
                }
            }    
        }
        

        return count;
    }
}