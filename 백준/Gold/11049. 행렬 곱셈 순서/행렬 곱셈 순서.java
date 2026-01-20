import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N;
    static int[] data;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];

         memo = new int[N+1][N+1];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
            data[i+1] = Integer.parseInt(st.nextToken());
        }
        // 간격
        for(int i = 2; i< N+1; i++){
            // 시작 점
            for(int j = 0; j< N+1-i; j++){
                memo[j][j+i] = Integer.MAX_VALUE;
                for(int k = 1; k< i;k++){
                    int value = memo[j][j+k] + memo[j+k][j+i] + data[j] * data[j+k] *data[j+i];

                    memo[j][j+i] = Math.min(memo[j][j+i], value);
                }
            }
        }

        System.out.println(memo[0][N]);

    }

}