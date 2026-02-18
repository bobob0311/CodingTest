import java.io.*;
import java.util.*;

/*
인접한 모든 자리의 차이가 1인 경우를 계단수라고 칭한다.
N이 주어질 때, 길이가 N이면서 0부터 9까지 숫자가 모두 등장하는 계단수가 총 몇 개 있는지 구하는 프로그램을 작성

- 0으로 시작하는 수는 계단수가 아니다.

첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력
0하고 9인경우는 1이랑 8이 고정
나머지는 +- 1씩 두개가 가능하다.

*/

public class Main {

    static int DIV = 1000000000;
    static int N;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10][1<<10];
        for(int i = 1; i<=9; i++){
            dp[1][i][1<<i] = 1;
        }
        
        for(int n =2; n<=N; n++){
            for(int k = 0; k<=9; k++){
                for(int visit = 0; visit < (1 <<10); visit++){
                    int nextVisit = visit | (1<<k);
                    
                    if(k == 0) dp[n][k][nextVisit] += dp[n-1][1][visit] % DIV;
                    else if(k == 9) dp[n][k][nextVisit] += dp[n-1][8][visit] % DIV;
                    else{
                        dp[n][k][nextVisit] += dp[n-1][k-1][visit] % DIV + dp[n-1][k+1][visit] % DIV;
                    }
                    
                    dp[n][k][nextVisit] %= DIV;
                }
            }
            
            
        }
        
        long answer = 0;
        for(int i = 0; i<=9; i++){
            answer += dp[N][i][1023] % DIV;
            answer %=DIV;
        }
        System.out.println(answer);
        
        
        
    }
    
}