import java.util.*;
import java.io.*;
/*
3으로 나누는것
2로 나누는것
1를 빼는 것
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> que = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] answer = new int[N + 1];

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            answer[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                answer[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                answer[i] = i / 2;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N] + "\n");
        int now = N;
        while (now != 1) {
            sb.append(now + " ");
            now = answer[now];
        }
        sb.append("1 ");
        System.out.println(sb.toString());

    }
}