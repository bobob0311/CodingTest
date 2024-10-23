import java.util.*;

class Solution {
    static int maxValue = 0;
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] chkMap = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!chkMap[i][j]){
                    if(picture[i][j] == 0){
                        chkMap[i][j] = true;
                        continue;
                    }else{
                        que.add( new int[] {i,j,picture[i][j]});
                        chkMap[i][j] = true;
                        maxValue = 1;
                        numberOfArea++;
                    }
                }
                
                while(!que.isEmpty()){
                    int[] arr = que.poll();
                    int X = arr[0];
                    int Y = arr[1];
                    int value = arr[2];
                    int[] dx = new int[] {X+1,X-1,X,X};
                    int[] dy = new int[] {Y,Y,Y+1,Y-1};
                    for(int k = 0; k<4; k++){
                        int nowX = dx[k];
                        int nowY = dy[k];
                        
                        if(nowX>=0 && nowX<m && nowY >=0 && nowY <n && picture[nowX][nowY] == value && !chkMap[nowX][nowY]){
                            que.add(new int[] {nowX,nowY,value});
                            chkMap[nowX][nowY] = true;
                            maxValue++;
                        }
                    }

                    
                    
                }
                maxSizeOfOneArea = Math.max(maxValue,maxSizeOfOneArea);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}