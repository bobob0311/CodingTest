import java.io.*;
import java.util.*;

/*
N명의 사람과 N개의 일이 존재 각 사람은 일을 하나 담당
각 일을 담당하는 사람은 한명

Dij를 i번 사람이 j번 일을 할 때 필요한 비용이라고 했을 때, 모든 일을 하는데 필요한 비용의 최솟값을 구하는 프로그램을 작성

*/

public class Main {

    static int N;
    static int[][] jobs;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //1 ~ 20;

        jobs = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int nowJob = Integer.parseInt(st.nextToken());
                jobs[i][j] = nowJob;
            }
        }

        int[][] dp = new int[N][(1 << N)];

        int MAXVALUE = Integer.MAX_VALUE/2;

        for(int i = 0; i<N; i++){
                Arrays.fill(dp[i],MAXVALUE);

        }
        for(int i = 0; i<N; i++){
            dp[0][1<<i] = jobs[0][i];
        }

        // i번째 인부가
        for(int i = 1; i<N; i++) {
            // j번째 일을 할때
            for (int j = 0; j < N; j++) {
                // 이전까지의 선택
                for (int visit = 0; visit < (1 << N); visit++) {
                    int nextVisit = visit | (1 << j);

                    dp[i][nextVisit] = Math.min(dp[i - 1][visit] + jobs[i][j], dp[i][nextVisit]);

                }
            }
        }

        System.out.println(dp[N-1][(1<<N)-1]);


    }

}