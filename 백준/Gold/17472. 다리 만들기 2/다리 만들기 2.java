import java.io.*;
import java.util.*;

/*
모든 섬을 다리로 연결
N * M 이차원 격자로 땅이거나 바다

다리는 바다에만 건설 (길이는 격자에서 차지하는 칸의 수) => 모든 섬을 연결해야한다.
1. 다리는 바다에만 건설
2. 방향이 중간에 바뀌면 안된다.
 => 다리의 방향은 가로 또는 세로 => 방향이 세로(가로)이면 다리의 양끝이 세로(가로) 방향으로 섬과 인접해야한다.
3. 길이는 2 이상

교차하는 경우 각 칸이 각 다리의 길이에 모두 포함되어야한다.
*/

public class Main {
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int answer = 0;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int idx = 1;
        // 우선 섬을 숫자로 구분?
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] !=0 && !visited[i][j]){
                    que.add(new int[] {i,j});
                    visited[i][j] = true;
                    while(!que.isEmpty()){
                        int[] nowNode = que.poll();
                        int nowX = nowNode[0];
                        int nowY = nowNode[1];

                        map[nowX][nowY] = idx;
                        for(int k = 0; k<4; k++){
                            int nextX = nowX + dx[k];
                            int nextY = nowY + dy[k];

                            if(nextX>=0 && nextX < N && nextY>=0 && nextY<M && !visited[nextX][nextY] && map[nextX][nextY]!= 0 ){
                                que.add(new int[]{nextX,nextY});
                                visited[nextX][nextY] = true;
                            }
                        }

                    }
                    idx++;
                }

            }
        }

        int landCnt = idx;
        int[][] bridgeLength = new int[landCnt][landCnt];
        for(int i = 0; i<landCnt; i++){
            Arrays.fill(bridgeLength[i],Integer.MAX_VALUE);
        }

        // 오른쪽으로 가거나
        for(int i = 0; i<N; i++){
            int prev = -1;
            int cnt = 0;
            for(int j = 0; j<M; j++){
                // 바다가 아닌 땅일때
                if(map[i][j] != 0){
                    // 만약 첫땅에 들어온것이다?
                    if(prev == -1){
                        prev = map[i][j];
                        // 내가 지금있는땅이 첫들어온땅이다.
                    }else if(prev == map[i][j]){
                        cnt=0;
                    }else if(prev != map[i][j]){
                        if(cnt >1){
                            bridgeLength[prev][map[i][j]] = Math.min(bridgeLength[prev][map[i][j]], cnt);
                            bridgeLength[map[i][j]][prev] = Math.min(bridgeLength[map[i][j]][prev], cnt);
                        }
                        prev = map[i][j];
                        cnt = 0;
                    }

                } else if (prev != -1) {
                    cnt++;
                }
            }
        }

        // 아래로 가거나 두가지 경우밖에 없는듯?
        for(int i = 0; i<M; i++){
            int prev = -1;
            int cnt = 0;
            for(int j = 0; j<N; j++){
                if(map[j][i] != 0){
                    if(prev == -1){
                        prev = map[j][i];
                    }else if(prev == map[j][i]){
                        cnt=0;
                    }else if(prev != map[j][i]){
                        if(cnt > 1){
                            bridgeLength[prev][map[j][i]] = Math.min(bridgeLength[prev][map[j][i]], cnt);
                            bridgeLength[map[j][i]][prev] = Math.min(bridgeLength[map[j][i]][prev], cnt);
                        }
                        prev = map[j][i];
                        cnt = 0;
                    }

                } else if (prev != -1) {
                    cnt++;
                }
            }
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        for(int i = 1; i<landCnt; i++){
            for(int j = 1; j<landCnt; j++){
                if(i == j || bridgeLength[i][j] == Integer.MAX_VALUE) continue;
                pq.add(new int[] {i,j,bridgeLength[i][j]});
            }
        }

        int[] parent = new int[landCnt];
        for(int i = 1; i<landCnt; i++){
            parent[i] = i;
        }

        int connect = 0;

        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int nowV1 = nowNode[0];
            int nowV2 = nowNode[1];
            int size = nowNode[2];

            if(find(nowV1,parent) !=find(nowV2,parent)){
                answer += size;
                union(nowV1,nowV2,parent);
                connect++;
            }
        }
        if(connect != landCnt-2){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    static void union(int v1, int v2, int[] parent){
        int rootV1 = find(v1,parent);
        int rootV2 = find(v2,parent);
        if(rootV1 != rootV2){
            parent[rootV2] = rootV1;
        }
    }
    static int find(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
}