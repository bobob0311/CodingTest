class Solution {
    int[] dx = {0,0,  1,1,  -1,-1,  1,-1};
    int[] dy = {1,-1,  1,-1,  1,-1,  0,0};
    public int solution(int[][] board) {
        int  cnt = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == 0){
                    int y = i;
                    int x = j;
                    boolean chk = true;
                    for(int k = 0; k<8; k++){
                        int nowY = y+dy[k];
                        int nowX = x+dx[k];
                        if(nowY < board.length && nowY >= 0 && nowX < board.length && nowX >=0){
                            if(board[nowY][nowX] == 1){
                                chk = false;
                            };
                        }
                    }
                    if(chk){
                        System.out.println("y"+i+"x"+j);
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}