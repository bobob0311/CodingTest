package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준4963 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    static int[] da = { 1, 1, 1, -1, -1, -1, 0, 0 };
    static int[] db = { 1, 0, -1, 1, 0, -1, 1, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로

            if (N == 0 && M == 0) {
                break;
            }
            visited = new boolean[N][M];
            graph = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

        }
        while (!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }
    }

    static void bfs() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    count += 1;
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });
                }
                while (!queue.isEmpty()) {
                    int[] arr = queue.poll();
                    int a = arr[0];
                    int b = arr[1];
                    for (int k = 0; k < 8; k++) {
                        int aa = a + da[k];
                        int bb = b + db[k];
                        if (aa >= 0 && aa < N && bb >= 0 && bb < M && visited[aa][bb] == false && graph[aa][bb] == 1) {
                            visited[aa][bb] = true;
                            queue.add(new int[] { aa, bb });
                        }

                    }
                }

            }
        }
        queue2.add(count);

    }

}
