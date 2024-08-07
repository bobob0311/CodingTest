package Programmers.고득점kit.DFS_BFS;

class Solution {
    static boolean[] visited;
    static int count = 0;

    static void dfs(int x, int[][] computers) {
        visited[x] = true;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[x][i] == 1) {
                dfs(i, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i, computers);
            }
        }
        return count;
    }
}
