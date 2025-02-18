import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length + 1][m + 1];

        for (int i = 0; i <= info.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 0; i < info.length; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int j = 0; j < m; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + aTrace);

                if (j + bTrace <= m) {
                    dp[i + 1][j + bTrace] = Math.min(dp[i + 1][j + bTrace], dp[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }

        return (answer >= n) ? -1 : answer;
    }
}