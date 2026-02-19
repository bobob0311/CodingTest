import java.io.*;
import java.util.*;

/*
1~N 까지 번호가 있으며 한 도시에서 출발해서 N개의 도시를 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로!!

1. 한 번 갔던 도시는 다시 갈 수 없다.
2. 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
*/

public class Main {

    static int N; // 도시의 수 (2 <= N <= 16)
    static int[][] costs;
    static int[][] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        dp = new int[N][(1<<N)]; 


        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());
                costs[i][j] = value;
            }
        }

        for(int i=0;i<N;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][1] = 0;

        for(int visit = 1; visit < (1<<N); visit++){
            for(int last = 0; last<N; last++){
                if((visit & (1<<last)) == 0) continue;
                for(int next=0; next<N; next++){
                    
                    if((visit & (1<<next)) != 0) continue; 
                    if(costs[last][next]==0) continue;
                    
                    int nextVisit = visit | (1<<next);
                    dp[next][nextVisit] = Math.min(dp[next][nextVisit], dp[last][visit] + costs[last][next]);
                }
            }
        }



        int answer = Integer.MAX_VALUE;
        for(int i=1; i<N; i++){
            if(costs[i][0] == 0) continue;
            answer = Math.min(answer, dp[i][(1<<N)-1] + costs[i][0]);
        }
        System.out.println(answer);

    }

}