package Programmers.Lv_2;

import java.util.*;
// 문제를 잘 읽고 풀자고요..
/*
(M,N);
*/

class Solution {
    static int[][] map;
    static int targetIdxX;
    static int targetIdxY;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public int solution(String[] board) {
        int M = board[0].length();
        int N = board.length;

        map = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == '.') {
                    map[i][j] = 1;
                } else if (board[i].charAt(j) == 'D') {
                    map[i][j] = 0;
                } else if (board[i].charAt(j) == 'G') {
                    targetIdxX = i;
                    targetIdxY = j;
                    map[i][j] = 1;
                } else {
                    que.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                    map[i][j] = 1;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int nowX = arr[0];
            int nowY = arr[1];
            int nowCount = arr[2];
            if (nowX == targetIdxX && nowY == targetIdxY) {
                return nowCount;
            }

            for (int i = 0; i < 4; i++) {
                int currentX = nowX;
                int currentY = nowY;
                while (true) {
                    if (currentX + dx[i] < 0 || currentX + dx[i] > N - 1 || currentY + dy[i] < 0
                            || currentY + dy[i] > M - 1 || map[currentX + dx[i]][currentY + dy[i]] == 0) {
                        if (visited[currentX][currentY] == false) {
                            visited[currentX][currentY] = true;
                            que.add(new int[] { currentX, currentY, nowCount + 1 });
                        }
                        break;

                    }
                    currentX += dx[i];
                    currentY += dy[i];
                }

            }
        }

        return -1;
    }
}