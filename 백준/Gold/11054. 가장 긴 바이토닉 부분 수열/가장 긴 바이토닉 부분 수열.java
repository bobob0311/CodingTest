import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            int now = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < now) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dp[i][1] = 1;
            int now = arr[i];
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < now) {
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i][0] + dp[i][1]);
        }
        System.out.println(answer-1);

    }
}