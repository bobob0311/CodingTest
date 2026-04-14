import java.io.*;
import java.util.*;

/*
N개 있고 연결이 나와있을때 여행이 가능할지 판별하는 프로그램을 작성해라
같은 도시 여러 번 방문하는 것도 가능하다.
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] map;
    static int[] route;
    static boolean[] visited;

    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M == 0) {
            System.out.println("YES");
            return;
        }

        route = new int[M];
        map= new int[N][N];
        visited = new boolean[N];
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            route[i] = Integer.parseInt(st.nextToken()) -1;
        }

        bfs();

        for(int city : route){
            if(!visited[city]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void bfs(){
       int startCity = route[0];
       visited[startCity] = true;
       que.add(startCity);

       while(!que.isEmpty()){
           int nowCity = que.poll();

           for(int i = 0; i<N; i++){
               int nextCityVal = map[nowCity][i];
               // 방문하지 않았는데 갈 수 있는 경우
               if(!visited[i] && nextCityVal == 1){
                   visited[i] = true;
                   que.add(i);
               }
           }
       }
    }
}