import java.io.*;
import java.util.*;

/*
각각의 마을에 한명 학생

X번째 마을에서 파티
즉 1->X X->1 2->X X->2 ... 이렇게 다 구해야함
N = 1000
M = 10000
모든 경로에서 모든 경로를 구해야할듯?
*/

public class Main {
    static int MAX = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        int[][] dist = new int[N+1][N+1];
        for(int i = 0; i< N+1; i++){
            Arrays.fill(dist[i],MAX);
        }
        
        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dist[start][end] = value;
        }
        
        for(int i = 1; i< N+1; i++){
            for(int j = 1; j< N+1; j++){
                for(int k = 1; k< N+1; k++){
                    int nowDist = dist[j][i] + dist[i][k];
                    if(dist[j][k] > nowDist) {
                        dist[j][k] = nowDist;
                    }
                }
            }
        }
        int answer = 0;
        
        for(int i = 1; i<N+1; i++){
            int nowDist = dist[i][target] + dist[target][i];
            if(answer < nowDist) answer= nowDist;
        }
        System.out.println(answer);
    }
}
