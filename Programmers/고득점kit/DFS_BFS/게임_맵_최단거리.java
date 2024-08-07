package Programmers.고득점kit.DFS_BFS;

import java.util.*;

class Solution {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[] arr;
    static boolean[][] visited;
    static int N, M;
    static Queue<int[]> que = new LinkedList<>();

    static int bfs(int x, int y, int[][] maps) {
        que.add(new int[] { x, y, 1 });
        while (!que.isEmpty()) {
            arr = que.poll();
            int X = arr[0];
            int Y = arr[1];
            int count = arr[2];

            visited[X][Y] = true;
            for (int i = 0; i < 4; i++) {
                if (X + dx[i] >= 0 && X + dx[i] <= M && Y + dy[i] >= 0 && Y + dy[i] <= N
                        && maps[X + dx[i]][Y + dy[i]] == 1 && visited[X + dx[i]][Y + dy[i]] == false) {
                    if (X + dx[i] == M && Y + dy[i] == N) {
                        return count + 1;
                    }
                    que.add(new int[] { X + dx[i], Y + dy[i], count + 1 });
                    visited[X + dx[i]][Y + dy[i]] = true;

                }
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        M = maps.length - 1;
        N = maps[0].length - 1;
        visited = new boolean[M + 1][N + 1];
        return bfs(0, 0, maps);
    }
}
