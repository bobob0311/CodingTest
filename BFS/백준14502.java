package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

public class 백준14502 {
    static int N, M;
    static int[][] graph;

    static int count = 1;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static Queue<int[]> queue = new LinkedList<>();
    static int temp[];
    static int aMax = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로의 수
        M = Integer.parseInt(st.nextToken()); // 세로의 수

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(aMax);
    }

    static void dfs(int count) {

        if (count == 3) {
            visited = new boolean[N][M];
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 || graph[i][j] == 2) {
                    continue;
                }
                graph[i][j] = 1;
                dfs(count + 1);
                graph[i][j] = 0;
            }
        }

    }

    static void bfs() {
        int[][] tempgraph = new int[N][M];

        for (int i = 0; i < graph.length; i++) {
            tempgraph[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempgraph[i][j] == 2 && visited[i][j] == false) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        temp = queue.poll();
                        int a = temp[0];
                        int b = temp[1];

                        for (int k = 0; k < 4; k++) {
                            if (a + dx[k] >= 0 && a + dx[k] < N &&
                                    b + dy[k] >= 0 && b + dy[k] < M && tempgraph[a + dx[k]][b + dy[k]] == 0) {
                                tempgraph[a + dx[k]][b + dy[k]] = 2;
                                visited[a + dx[k]][b + dy[k]] = true;
                                queue.add(new int[] { a + dx[k], b + dy[k] });
                            }
                        }

                    }

                }
            }
        }
        check(tempgraph);
    }

    static void check(int[][] sub) {
        int cnt = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (sub[i][j] == 0)
                    cnt++;

        aMax = Math.max(aMax, cnt);
    }

}
