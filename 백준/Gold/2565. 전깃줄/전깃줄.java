import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, (a, b) -> Integer.compare(a[0], b[0]));
        int answer = 0;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            int now = map[i][1];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (map[j][1] < now) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}