class Solution {
    static int max = 0;

    public int solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int v = Math.min(
                                dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        dp[i][j] = v;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return (int) Math.pow(max, 2);
    }
}