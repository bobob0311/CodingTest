import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < now) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);

        }
        System.out.println(answer);

    }
}