import java.util.*;
import java.io.*;

/*
한칸씩 가거나, 두칸씩 가거나
근데 3칸을 연속으로 밟을 수는 없다. 

전에 한칸으로 올라왔으면 무조건 두칸을 뛰어야되네 

dp[i] = Math.max(dp[i-2], dp[i-1])
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[][] dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if(N==1){
            System.out.println(arr[0]);
            return;
        }else if(N ==2){
            System.out.println(arr[0] + arr[1]);
            return;
        }

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        // 한칸 뛰어온거
        dp[1][0] = dp[0][0] + arr[1];
        // 두칸 뛴거
        dp[1][1] = arr[1];

        for (int i = 2; i < N; i++) {
            // 한칸뛰어서 올라면 전에 2칸 왔었어야함
            dp[i][0] = dp[i - 1][1] + arr[i];
            // 두칸뛰어서 온거면 전에 한칸이든 두칸이든 상관없음
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][0]) + arr[i];
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));

    }
}