package Programmers.고득점kit.완전탐색;

class Solution {
    static boolean[] visited;
    static int _max = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);
        return _max;
    }

    static void dfs(int[][] dungeons, int count, int hp) {
        _max = Math.max(_max, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, count + 1, hp - dungeons[i][1]);
                visited[i] = false;

            }
        }
    }
}
