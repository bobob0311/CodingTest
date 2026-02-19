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

        //N번째 집을 3가지 색으로 칠했을때 최소값을 저장해야한다.
        // 처음 시작한걸 마지막에 저장해야할듯?

        dp = new int[N][3][3];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<3; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE/2);
            }
        }

        for(int i = 0; i<3; i++){
            dp[0][i][i] = costs[0][i];
        }



        for(int i = 1; i<N; i++){
            if(i == N-1){
                for(int j = 0; j<3; j++){
                    if(j==0){
                        dp[i][j][1] = Math.min(dp[i-1][1][1],dp[i-1][2][1]) + costs[i][j];
                        dp[i][j][2] = Math.min(dp[i-1][1][2],dp[i-1][2][2])+ costs[i][j];
                    }else if(j ==1){
                        dp[i][j][0] = Math.min(dp[i-1][0][0],dp[i-1][2][0])+ costs[i][j];
                        dp[i][j][2] = Math.min(dp[i-1][0][2],dp[i-1][2][2])+ costs[i][j];
                    }else{
                        dp[i][j][0] = Math.min(dp[i-1][1][0],dp[i-1][0][0])+ costs[i][j];
                        dp[i][j][1] = Math.min(dp[i-1][1][1],dp[i-1][0][1])+ costs[i][j];
                    }

                }
            }else{



            for(int j = 0; j<3; j++){
                for(int k = 0; k<3; k++){
                    if(k == 0){
                        dp[i][k][j] = Math.min(dp[i-1][1][j], dp[i-1][2][j]) + costs[i][k];
                    }else if(k == 1){
                        dp[i][k][j] = Math.min(dp[i-1][0][j], dp[i-1][2][j]) + costs[i][k];
                    }else{
                        dp[i][k][j] = Math.min(dp[i-1][0][j], dp[i-1][1][j]) + costs[i][k];
                    }
                }

            }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        System.out.println(answer);
    }

}