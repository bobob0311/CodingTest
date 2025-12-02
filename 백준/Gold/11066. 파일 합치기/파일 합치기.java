import java.io.*;
import java.util.*;

/*
연속된 파일을 합치는데 cost가 들고 모든 파일을 합쳐야할때 최소로 필요한 비용을 계산

K <= 500
파일크기는 각 10000이하

작은거끼리 여러번 합치는게 좋을거같은데
*/

public class Main {
    static int K;
    static int[] files;
    static int[] preSum;
    static int[][] dp;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 0; t<T; t++){
            K = Integer.parseInt(br.readLine());

            files = new int[K];
            preSum = new int[K+1];
            dp = new int[K][K];

            for(int i = 0; i<K; i++){
                Arrays.fill(dp[i],-1);
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i< K; i++){
                files[i] = Integer.parseInt(st.nextToken());
                preSum[i+1] = preSum[i] + files[i];
            }
            System.out.println(sol(0,K-1));
        }
    }

    static public int sum(int s, int e){
        return preSum[e+1] - preSum[s];
    }

    static public int sol(int start, int end){
        if(start == end) return 0;

        if(dp[start][end] != -1) return dp[start][end];

        int temp = INF;

        for(int mid = start; mid<end; mid++){
            temp = Math.min(temp, sol(start,mid) + sol(mid +1, end) + sum(start,end));
        }

        return dp[start][end] = temp;
    }
}
