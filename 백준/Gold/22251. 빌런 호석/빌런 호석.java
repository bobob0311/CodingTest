import java.io.*;
import java.util.*;

/*


*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int answerCnt = 0;
    static int N,K,P,X;
    static int[] arr, nums;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N이하가 되어야한다.
        N = Integer.parseInt(st.nextToken());
        // K자리 수
        K = Integer.parseInt(st.nextToken());
        // 최대 P개를 반전
        P = Integer.parseInt(st.nextToken());
        // 실제로 X층에 있음
        X = Integer.parseInt(st.nextToken());

        arr = new int[10];
        nums = new int[K];
        int idx = K-1;
        while(idx >=0 && X >=0){
            nums[idx--] = X % 10;
            X /=10;
        }


        arr[0] = 0b1110111;
        arr[1] = 0b0010010;
        arr[2] = 0b1011101;
        arr[3] = 0b1011011;
        arr[4] = 0b0111010;
        arr[5] = 0b1101011;
        arr[6] = 0b1101111;
        arr[7] = 0b1010010;
        arr[8] = 0b1111111;
        arr[9] = 0b1111011;

        dp = new int[10][10];

        for(int i = 0; i<10; i++){
            for(int j = 0; j<10;j++){
                dp[i][j] = Integer.bitCount(arr[i] ^ arr[j]);
            }
        }

        dfs(0,0,0);
        System.out.println(answerCnt);
    }

    static void dfs(int cnt, int step,int val){
        if(step == K) {
            if(val <=N && cnt != 0 && cnt<=P && val != 0){
                answerCnt++;
            }
            return;
        }
        if(cnt > P || val >N) {
            return;
        };

        int nowNum = nums[step];
        for(int i = 0; i<10; i++){
            dfs(cnt+dp[nowNum][i], step +1, val + (int)Math.pow(10,K-step-1) * i);
        }


    }



}