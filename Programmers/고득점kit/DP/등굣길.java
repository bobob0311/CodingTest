package Programmers.고득점kit.DP;

//쉬웠는데 1000000007로 나눠줘야 하는걸 놓침;;

/*
아래와 오른쪽으로만 이동할 수 있는데 이렇게 이동해서 도착하면 무조건 최단 경로일 수 밖에없음.

*/

class Solution {
    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        map = new int[m + 1][n + 1];
        map[1][1] = 1;
        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != -1) {
                    if (i + 1 <= m && map[i + 1][j] != -1) {

                        map[i + 1][j] = (map[i][j] + map[i + 1][j]) % 1000000007;
                    }
                    if (j + 1 <= n && map[i][j + 1] != -1) {
                        map[i][j + 1] = (map[i][j] + map[i][j + 1]) % 1000000007;
                    }
                }

            }
        }

        return map[m][n] % 1000000007;
    }
}
