import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준1012 {
    static int TC;
    static int M, N, K, a, b;
    static int[][] graph;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int result;
    static int[] arr;
    static int X, Y;

    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    static void bfs(int x, int y) {
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            arr = queue.poll();
            X = arr[0];
            Y = arr[1];
            for (int i = 0; i < 4; i++) {
                if (X + dx[i] >= 0 && X + dx[i] < M && Y + dy[i] >= 0 && Y + dy[i] < N
                        && graph[X + dx[i]][Y + dy[i]] == 1 && !visited[X + dx[i]][Y + dy[i]]) {
                    queue.add(new int[] { X + dx[i], Y + dy[i] });
                    visited[X + dx[i]][Y + dy[i]] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        TC = Integer.parseInt(br.readLine());

        for (int q = 0; q < TC; q++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            result = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    if (graph[i][j] == 1 && !visited[i][j]) {

                        result += 1;
                        bfs(i, j);
                    }

                }
            }

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

}
