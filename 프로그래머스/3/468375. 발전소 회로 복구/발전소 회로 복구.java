import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n,m;
    
    static int[] el;
    
    static int[][][][] dp;
    static Queue<Integer[]> que = new LinkedList<>();
    
    static boolean[][] visited;
    static char[][] map;
    
    static int[] preMask;
    static int[][] memo;
    static final int INF = 1_000_000_000;
    
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        n = grid.length;
        m = grid[0].length();
        
        preMask = new int[panels.length + 1];
        map = new char[n][m];
        
        dp = new int[n][m][n][m];
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                char val = grid[i].charAt(j);
                map[i][j] = val;
                
                if(val == '@') el = new int[] {i,j};
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int x = 0; x < n; x++){
                    Arrays.fill(dp[i][j][x], -1);
                }
            }
        }
        
        calcPreMask(seqs);
        
        bfs(el[0], el[1]);
        for(int i = 0; i < panels.length; i++){
            bfs(panels[i][1]-1, panels[i][2]-1);
        }
        
        memo = new int[1 << panels.length][panels.length + 1];
        for(int i = 0; i < (1 << panels.length); i++){
            Arrays.fill(memo[i], -1);
        }
        
        
        int answer = dfs(0,0,panels);
        return answer;
    }
    
    static void calcPreMask(int[][] seqs){
        for(int i = 0; i < seqs.length; i++){
            int from = seqs[i][0];
            int to = seqs[i][1];

            preMask[to] |= (1 << (from - 1));
        }
    }

    static int dfs(int mask, int lastPanelIdx, int[][] panels){
        if(mask == (1 << panels.length) - 1) return 0;

        if(memo[mask][lastPanelIdx] != -1) return memo[mask][lastPanelIdx];

        int min = INF;

        for(int next = 1; next <= panels.length; next++){
            int bit = 1 << (next - 1);

            if((mask & bit) != 0) continue;
            if((mask & preMask[next]) != preMask[next]) continue;

            int cost;

            if(lastPanelIdx == 0){
                cost = startMoveCost(next, panels);
            }else{
                cost = moveCost(lastPanelIdx, next, panels);
            }

            if(cost == -1) continue;

            int nextVal = dfs(mask | bit, next, panels);
            if(nextVal == INF) continue;

            min = Math.min(min, cost + nextVal);
        }

        return memo[mask][lastPanelIdx] = min;
    }

    static int startMoveCost(int endPanelIdx, int[][] panels){
        int[] startPanel = panels[0];
        int[] endPanel = panels[endPanelIdx - 1];

        int startX = startPanel[1]-1;
        int startY = startPanel[2]-1;

        int endX = endPanel[1]-1;
        int endY = endPanel[2]-1;

        if(startPanel[0] != endPanel[0]){
            int a = dp[startX][startY][el[0]][el[1]];
            int b = dp[el[0]][el[1]][endX][endY];

            if(a == -1 || b == -1) return -1;

            return a + b + Math.abs(startPanel[0] - endPanel[0]);
        }else{
            return dp[startX][startY][endX][endY];
        }
    }
    
    static int moveCost(int startPanelIdx, int endPanelIdx,int[][] panels){
        int[] startPanel = panels[startPanelIdx-1];
        int[] endPanel = panels[endPanelIdx-1];
        
        int startX = startPanel[1]-1;
        int startY = startPanel[2]-1;
        
        int endX = endPanel[1]-1;
        int endY = endPanel[2]-1;
        
        int cost = 0;
        if(startPanel[0] != endPanel[0]){
            cost += dp[startX][startY][el[0]][el[1]] + dp[el[0]][el[1]][endX][endY] + Math.abs(startPanel[0] - endPanel[0]);
            
        }else{
            cost += dp[startX][startY][endX][endY];
        }
        return cost;
    }
    
    static void bfs(int startX, int startY){
        visited = new boolean[n][m];
        
        visited[startX][startY] = true;
        
        if(map[startX][startY] == '#') {
            for(int i = 0; i<n; i++){
                Arrays.fill(dp[startX][startY][i], -1);
            }
            return;
        }
        
        que.add(new Integer[] {startX,startY,0});
        while(!que.isEmpty()){
            Integer[] nowNode = que.poll();
            int nowX = nowNode[0];
            int nowY = nowNode[1];
            int val = nowNode[2];
            
            dp[startX][startY][nowX][nowY] = val;
            
            for(int i = 0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(isCan(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    que.add(new Integer[] {nextX,nextY, val + 1});
                }
            }
        }
        
        
    }
    
    static boolean isCan(int nextX, int nextY){
        return nextX >= 0 && nextX < n && nextY >=0 && nextY <m && !visited[nextX][nextY] && map[nextX][nextY] != '#';
    }
}