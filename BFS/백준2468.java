package CodingTest.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2468 {
    static int N;
    static int[][] graph;
    static int aMax = 0;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로의 수

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 1; k < 100; k++) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] < k) {
                        visited[i][j] = true;
                    }
                }
            }

            bfs();
        }
        System.out.println(aMax);

    }

    static void bfs() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] target = queue.poll();
                        int a = target[0];
                        int b = target[1];
                        for (int k = 0; k < 4; k++) {
                            if (a + dx[k] >= 0 && a + dx[k] < N &&
                                    b + dy[k] >= 0 && b + dy[k] < N && visited[a + dx[k]][b + dy[k]] == false) {
                                visited[a + dx[k]][b + dy[k]] = true;
                                queue.add(new int[] { a + dx[k], b + dy[k] });
                            }
                        }
                    }
                }
                check(count);
            }

        }

    }

    static void check(int value) {
        aMax = Math.max(aMax, value);
    }
}
