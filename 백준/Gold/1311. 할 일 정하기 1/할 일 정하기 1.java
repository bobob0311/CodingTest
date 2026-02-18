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

        int size = 1 << N;
        int[] dp = new int[size];
        int INF = Integer.MAX_VALUE/2;
        Arrays.fill(dp,INF);
        dp[0] = 0;

        for(int i = 0; i<size; i++){
            int person = Integer.bitCount(i);

            if(person >=N) continue;

            for(int job = 0; job<N; job++){
                if((i & (1<<job)) ==0){
                    int next = i | (1<<job);
                    dp[next] = Math.min(dp[next], dp[i] + jobs[person][job]);
                }
            }
        }

        System.out.println(dp[(1<<N) -1]);


    }

}