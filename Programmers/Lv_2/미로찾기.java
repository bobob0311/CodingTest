package Programmers.Lv_2;

import java.util.*;

class Solution {
    static int[][] map;
    static int e_x;
    static int e_y;
    static int l_x;
    static int l_y;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public int solution(String[] maps) {
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> andQue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length()];

        int N = maps.length;
        int M = maps[0].length();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = 1;

                if (maps[i].charAt(j) == 'S') {
                    que.add(new int[] { i, j, 0 });
                } else if (maps[i].charAt(j) == 'E') {
                    e_x = i;
                    e_y = j;
                } else if (maps[i].charAt(j) == 'L') {
                    l_x = i;
                    l_y = j;
                } else if (maps[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int nowX = arr[0];
            int nowY = arr[1];
            int nowCount = arr[2];
            if (nowX == l_x && nowY == l_y) {
                andQue.add(new int[] { nowX, nowY, nowCount });
            }
            for (int i = 0; i < 4; i++) {
                int nX = nowX + dx[i];
                int nY = nowY + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && visited[nX][nY] == false && map[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    que.add(new int[] { nX, nY, nowCount + 1 });
                }
            }

        }

        visited = new boolean[maps.length][maps[0].length()];

        while (!andQue.isEmpty()) {
            int[] arr = andQue.poll();
            int nowX = arr[0];
            int nowY = arr[1];
            int nowCount = arr[2];
            if (nowX == e_x && nowY == e_y) {
                return nowCount;
            }
            for (int i = 0; i < 4; i++) {
                int nX = nowX + dx[i];
                int nY = nowY + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && visited[nX][nY] == false && map[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    andQue.add(new int[] { nX, nY, nowCount + 1 });
                }
            }

        }

        return -1;
    }
}
