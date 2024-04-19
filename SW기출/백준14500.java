package SW기출;

import java.io.*;
import java.util.*;

/*
백트래킹 문제가 아닐까 생각됩니다.
모든 경우의수 해보면 될듯?

2500*4*4*4 => 160000


 */
public class 백준14500 {
    static int[][] arr;
    static int N, M; // 세로 가로
    static int max_value = 0;
    static int now_sum;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] chk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        chk = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                chk[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                chk[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                how(i, j);
            }
        }

        System.out.println(max_value);

    }

    static void how(int y, int x) {
        int res = arr[y][x];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (y + dy[i] >= 0 && y + dy[i] < N && x + dx[i] >= 0 && x + dx[i] < M) {
                res += arr[y + dy[i]][x + dx[i]];
                count++;
            }
        }
        if (count == 3) {
            max_value = Math.max(max_value, res);
        }

        for (int i = 0; i < 4; i++) {
            if (y + dy[i] >= 0 && y + dy[i] < N && x + dx[i] >= 0 && x + dx[i] < M) {
                int result = res - arr[y + dy[i]][x + dx[i]];
                max_value = Math.max(max_value, result);
            }
        }

    }

    static void dfs(int y, int x, int count, int res) {
        if (count == 4) {
            max_value = Math.max(max_value, res);
            return;
        }

        for (int a = 0; a < 4; a++) {
            if (y + dy[a] >= 0 && y + dy[a] < N && x + dx[a] >= 0 && x + dx[a] < M
                    && chk[y + dy[a]][x + dx[a]] == false) {
                chk[y + dy[a]][x + dx[a]] = true;
                dfs(y + dy[a], x + dx[a], count + 1, res + arr[y + dy[a]][x + dx[a]]);
                chk[y + dy[a]][x + dx[a]] = false;
            }
        }
        return;
    }
}
