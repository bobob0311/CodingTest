import java.io.*;
import java.util.*;

/*
N개의 집이 있고 1~N번 집이 순서대로 있다.

빨강 ,  초록, 파랑 중 하나의 색으로  칠해야하며

각각의 집을 빨강 초록 파랑으로 칠하는 비용이 주어진다.
비용의 최솟값을 구하는 문제

- 1번집의 색은 2번,  N번 집의 색과 같지 않아야한다.
- N번집의 색은 N-1과 1과 같지 않아야한다.
- 인접한 집의 색은 달라야 한다.

=> 인접한 집의 색은 달라야하며 1과 N만 다르면 되는 문제
*/

public class Main {

    static int N; // 집의 수 (1<N);
    static int[][] costs;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        costs = new int[N][3];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                int value = Integer.parseInt(st.nextToken());
                costs[i][j] = value;
            }
        }

        int INF = Integer.MAX_VALUE / 2;
        int answer = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];
            for (int c = 0; c < 3; c++) {
                if (c == firstColor) dp[0][c] = costs[0][c];
                else dp[0][c] = INF;
            }

            for (int i = 1; i < N; i++) {
                for (int cur = 0; cur < 3; cur++) {
                    dp[i][cur] = INF;
                    for (int prev = 0; prev < 3; prev++) {
                        if (prev == cur) continue; 
                        dp[i][cur] = Math.min(dp[i][cur], dp[i - 1][prev] + costs[i][cur]);
                    }
                }
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                answer = Math.min(answer, dp[N - 1][lastColor]);
            }
        }

        System.out.println(answer);
    }

}