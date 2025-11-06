import java.io.*;
import java.util.*;

/*
첫째 열은 가스관 => 첫째열을 최대한 많이 지나가야한다.

오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로만 가능
우선 갈 수 있는 길을 찾는게 중요할듯? 어디에 도착하면 가지 못한다? 근데 전의 조건에 따라 달라질거같은데
그냥 500번 진행하는게 맞을 수도?
2,500,000,000


*/

public class Main {
    static int R,C;
    static int answer = 0;
    static boolean[][] visited;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i< R; i++){
            String nowStr = br.readLine();
            for(int j=0; j<C; j++){
                if(nowStr.charAt(j) == 'x'){
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i<R; i++){
            visited[i][0] = true;
            if(dfs(i,0)) answer++;
        }
        System.out.println(answer);
    }
    
    static public boolean dfs(int x,int y){
        if(y == C-1) return true;
        
        for(int i = 0; i<3; i++){
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if(inSpace(tempX,tempY) && !visited[tempX][tempY] && map[tempX][tempY] == 0){
                visited[tempX][tempY] = true;
                if(dfs(tempX,tempY)) return true;
            }
        }
        return false;
    }


    static public boolean inSpace(int x, int y){
        if(x>=0 && y>=0 && x<R && y<C) return true;
        return false;
    }
}
