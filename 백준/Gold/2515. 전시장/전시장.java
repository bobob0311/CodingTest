import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        }));
        int max = 0;

        int left = S;
        int right = 20000000;

        while (left <= right) {
            int mid = (left + right) / 2;
            int[] dp = new int[20000000 + 1];

            for (int i = 0; i < N; i++) {
                dp[arr[i][0]] = Math.max(arr[i][1], dp[arr[i][0]]);
            }

            for (int i = 1; i <= 20000000; i++) {
                if (i >= mid) {
                    dp[i] = Math.max(dp[i - mid] + dp[i], dp[i - 1]);
                }
            }

            if (max <= dp[arr[N - 1][0]]) {
                max = Math.max(dp[arr[N - 1][0]], max);
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(max);
    }
}