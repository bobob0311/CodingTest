import java.io.*;
import java.util.*;

// 2048
// 상하좌우 네 방향 중 하나로 이동시키는 것 충돌시 두 블록은 하나로 합쳐지게 된다.
// 한번 합쳐지면 또 다른 블록과 다시 합쳐질 수는 없다.
// 추가되는 블록은 없다.
// 5번 이동하여 얻을 수 있는 가장 큰 블록을 출력
// 보드의  크기는 20이하

// 계속 새로운 맵으로 시작하는 것은 비효율적인거같은데..
// 차라리 계속 만든다? 그래서 인수로 전달해주는게 어떤가? 4^5 => 16 * 64 <= 1000

// 백트래킹을 생각

public class Main {
    static StringTokenizer st;

    static int N;
    static int[][] initalMap, map;
    static Queue<Integer> que = new LinkedList<>();
    static int answer =0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        initalMap = new int[N][N];
        for(int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int v = Integer.parseInt(st.nextToken());
                initalMap[i][j] = v;
            }
        }

        dfs(0,initalMap);


        System.out.println(answer);
    }

    static int[][] createCopyMap(int[][] nowMap){
        int[][] copyMap = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++){
                copyMap[i][j] = nowMap[i][j];
            }
        }
        return copyMap;
    }

    static void dfs(int cnt, int[][]map){
        if(cnt == 5) {
            answer = Math.max(answer,findMaxValue(map));
            return;
        }

        left(map,cnt);
        right(map,cnt);
        up(map,cnt);
        down(map,cnt);
    }

    static int findMaxValue(int[][] nowMap){
        int maxValue = 0;

        for(int i = 0; i< N; i++){
            for(int j = 0; j<N; j++){
                maxValue = Math.max(maxValue, nowMap[i][j]);
            }
        }
        return maxValue;
    }

    static void left(int[][] prevMap,int cnt){
        int[][] map = createCopyMap(prevMap);
        for(int i =0; i< N;i++){
            for(int j =0; j<N; j++){
                if(map[i][j] != 0) que.add(map[i][j]);
            }

            int prev =-1;
            int idx =0;

            while(!que.isEmpty()){
                int now = que.poll();

                // 만약 전에 있는거랑 같은거면 합쳐주고 전에가 없다 이제 선언
                if(now == prev) {
                    map[i][idx++] = now * 2;
                    prev = -1;
                }else{
                    // 전에랑 다른데 prev가 -1이였으면 전게 없었다는것 그럼 그냥 prev만 바꿔주기
                    if(prev == -1){
                        prev = now;
                    }else{
                        // prev가 있었는데 못합쳐지는 경우 그냥 넣기 그리고 prev 현재껄로 바꾸기
                        map[i][idx++] = prev;
                        prev = now;
                    }
                }
                if(que.isEmpty() && prev != -1) map[i][idx++] = prev;
            }

            while(idx != N) map[i][idx++] = 0;
        }

        dfs(cnt+1,map);
    }

    static void right(int[][] prevMap, int cnt){
        int[][] map = createCopyMap(prevMap);
        for(int i =0; i< N;i++){
            for(int j =N-1; j>=0; j--){
                if(map[i][j] != 0) que.add(map[i][j]);
            }

            int prev =-1;

            int idx =N-1;

            while(!que.isEmpty()){
                int now = que.poll();

                if(now == prev) {
                    map[i][idx--] = now * 2;
                    prev = -1;
                }else{
                    if(prev == -1){
                        prev = now;
                    }else{
                        map[i][idx--] = prev;
                        prev = now;
                    }
                }
                if(que.isEmpty() && prev != -1) map[i][idx--] = prev;
            }

            while(idx != -1) map[i][idx--] = 0;
        }

        dfs(cnt+1,map);
    }

    static void up(int[][] prevMap,int cnt){
        int[][] map = createCopyMap(prevMap);
        for(int i =0; i< N;i++){
            for(int j =0; j<N; j++){
                if(map[j][i] != 0) que.add(map[j][i]);
            }

            int prev =-1;

            int idx =0;

            while(!que.isEmpty()){
                int now = que.poll();

                if(now == prev) {
                    map[idx++][i] = now * 2;
                    prev = -1;
                }else{
                    if(prev == -1){
                        prev = now;
                    }else{
                        map[idx++][i] = prev;
                        prev = now;
                    }
                }
                if(que.isEmpty() && prev != -1) map[idx++][i] = prev;
            }

            while(idx != N) map[idx++][i] = 0;
        }

        dfs(cnt+1,map);
    }

    static void down(int[][] prevMap, int cnt){
        int[][] map = createCopyMap(prevMap);
        for(int i =0; i< N;i++){
            for(int j =N-1; j>=0; j--){
                if(map[j][i] != 0) que.add(map[j][i]);
            }

            int prev =-1;

            int idx =N-1;

            while(!que.isEmpty()){
                int now = que.poll();

                if(now == prev) {
                    map[idx--][i] = now * 2;
                    prev = -1;
                }else{
                    if(prev == -1){
                        prev = now;
                    }else{
                        map[idx--][i] = prev;
                        prev = now;
                    }
                }
                if(que.isEmpty() && prev != -1) map[idx--][i] = prev;
            }

            while(idx != -1) map[idx--][i] = 0;
        }

        dfs(cnt+1,map);
    }


}