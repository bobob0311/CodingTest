import java.io.*;
import java.util.*;

/*
(i,j) 위치부터 (x,y) 위치까지에 저장되어 있는 수들의 합을 구해보자
*/

public class Main {
    static int N,M,K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for(int i = 1; i<N+1; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 1; j<M+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());
        int[][] sum = new int[N+1][M+1];

        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<M+1; j++){
                sum[i][j] = map[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            sb.append(sum[endX][endY] - sum[startX-1][endY] - sum[endX][startY-1] + sum[startX-1][startY-1] +"\n");

        }
        System.out.println(sb.toString());
    }
}
