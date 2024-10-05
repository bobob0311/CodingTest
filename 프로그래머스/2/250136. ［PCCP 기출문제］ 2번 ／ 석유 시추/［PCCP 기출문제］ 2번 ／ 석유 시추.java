import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] land) {
        int[] answerArr = new int[land[0].length];
        boolean[][] chk = new boolean[land.length][land[0].length];
        Queue<int[]> que = new LinkedList<>();
        
        for(int i =0; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(land[i][j] == 1 && chk[i][j] == false){
                    que.offer(new int[] {i,j});
                    int count = 1;
                    boolean[] chkLine = new boolean[land[0].length];
                    while(!que.isEmpty()){
                        int[] arr = que.poll();
                        int x = arr[0];
                        int y = arr[1];
                        chk[x][y] = true;
                                if(chkLine[y] == false){
                                    chkLine[y] = true;
                                }
                        for(int k = 0; k<4; k++){
                            if(x+dx[k] >=0 && x+dx[k] <land.length && y+dy[k] >=0 && y+dy[k] < land[0].length && chk[x+dx[k]][y+dy[k]] == false && land[x+dx[k]][y+dy[k]] == 1){  
                                que.offer(new int[] {x+dx[k], y+dy[k]});
                                if(chkLine[y+dy[k]] == false){
                                    chkLine[y+dy[k]] = true;
                                }
                                chk[x+dx[k]][y+dy[k]] = true;
                                count++;
                            }
                        }
                    }
                    for(int z = 0; z<land[0].length; z++){
                        if(chkLine[z]){
                            answerArr[z] += count;
                        }
                    }
                }
            }
        }
        int max =0;
        for(int i =0; i<land[0].length ; i++){
            max = Math.max(max,answerArr[i]);
        }
        
        
        return max;
    }
}