import java.io.*;
import java.util.*;

/*
4 * 4공간
한칸에 물고리 한 마리 존재
번호와 방향을 가지고있음
1. 번호는 1<= X <=16 다 다른 번호이다.
2. 방향은 8가지 방향

청소년 상어는 0,0 에 들어가서 물고기를 먹는다. 방향은 0,0에 있는 물고기의 방향과 동일

1. 물고기는 번호가 작은 물고기부터 순서대로 이동
2. 한칸을 이동할 수 있고
    2-1 빈칸과 다른 물고기가 있는 칸은 이동이 가능
    2-2 상어가 있거나 공간의 경계를 넘는 칸은 이동이 불가능
3. 각 물고기는 방향이 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다.
4. 이동할 수 있는 칸이 없을 경우 이동을 하지 않는다.
5. 칸을 이동할 경우 서로의 위치를 바꾸는 방식으로 이동한다.

==> 물고기의 이동이 모두 끝나면 상어가 이동한다.
상어가 물고기가 있는 칸으로 이동하면 그 칸에 있는 물고기를 먹고 물고기의 방향을 가지게 된다.
이동하는 중에 지나가는 칸에 있는 물고기는 먹지않고 물고기가 없는 칸으로는 이동할 수 없다.

상어 이동후 물고기 이동/ 이 과정이 반복된다.
*/

public class Main {

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[4][4];
        int[][] fishLoc = new int[17][2];
        int[] fishDir = new int[17];

        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;

                map[i][j] = num;
                fishLoc[num][0] = i;
                fishLoc[num][1] = j;
                fishDir[num] = dir;
            }
        }

        int firstFish = map[0][0];
        int sharkDir = fishDir[firstFish];

        fishLoc[firstFish][0] = -1;
        fishLoc[firstFish][1] = -1;

        map[0][0] = -1;

        dfs(map, fishLoc, fishDir, 0, 0, sharkDir, firstFish);

        System.out.println(answer);
    }

    static void dfs(int[][] map, int[][] fishLoc, int[] fishDir,
                    int sharkX, int sharkY, int sharkDir, int sum){

        answer = Math.max(answer, sum);

        int[][] newMap = copyMap(map);
        int[][] newFishLoc = copyFishLoc(fishLoc);
        int[] newFishDir = fishDir.clone();

        moveFish(newMap, newFishLoc, newFishDir, sharkX, sharkY);

        for(int i=1;i<=3;i++){

            int nx = sharkX + dx[sharkDir]*i;
            int ny = sharkY + dy[sharkDir]*i;

            if(nx<0 || nx>=4 || ny<0 || ny>=4) break;
            if(newMap[nx][ny] == 0) continue;

            int fishNum = newMap[nx][ny];

            int[][] nextMap = copyMap(newMap);
            int[][] nextFishLoc = copyFishLoc(newFishLoc);
            int[] nextFishDir = newFishDir.clone();

            nextMap[sharkX][sharkY] = 0;
            nextMap[nx][ny] = -1;

            nextFishLoc[fishNum][0] = -1;
            nextFishLoc[fishNum][1] = -1;

            dfs(nextMap, nextFishLoc, nextFishDir,
                    nx, ny, nextFishDir[fishNum], sum + fishNum);
        }
    }

    static void moveFish(int[][] map, int[][] fishLoc, int[] fishDir,
                         int sharkX, int sharkY){

        for(int i=1;i<=16;i++){

            if(fishLoc[i][0] == -1) continue;

            int x = fishLoc[i][0];
            int y = fishLoc[i][1];
            int d = fishDir[i];

            for(int k=0;k<8;k++){
                int nd = (d+k)%8;

                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
                if(nx == sharkX && ny == sharkY) continue;

                int target = map[nx][ny];

                // swap
                map[x][y] = target;
                map[nx][ny] = i;

                fishLoc[i][0] = nx;
                fishLoc[i][1] = ny;
                fishDir[i] = nd;

                if(target != 0){
                    fishLoc[target][0] = x;
                    fishLoc[target][1] = y;
                }

                break;
            }
        }
    }

    static int[][] copyMap(int[][] map){
        int[][] newMap = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static int[][] copyFishLoc(int[][] fishLoc){
        int[][] newLoc = new int[17][2];
        for(int i=1;i<=16;i++){
            newLoc[i][0] = fishLoc[i][0];
            newLoc[i][1] = fishLoc[i][1];
        }
        return newLoc;
    }
}