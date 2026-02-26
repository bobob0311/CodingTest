import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int MOD = 1000000003;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색상환에 포함된 수
        N = Integer.parseInt(br.readLine());
        // 선택해야하는 수
        K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][K+1];

        dp[1][1] = 1;
        dp[1][0] = 1;

        dp[2][1] = 2;
        dp[2][0] = 1;


        if (K == 1) {
            System.out.println(N);
            return;
        }
        
        for(int i =3; i<N+1; i++){
            for(int j = 0; j<K+1; j++){
                if(j == 0) {
                    dp[i][j] = 1;
                    continue;
                };
                if(j > (i+1)/2) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % MOD;
            }
        }



        System.out.println((dp[N-3][K-1] + dp[N-1][K]) % MOD);

    }

}