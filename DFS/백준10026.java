package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10026 {
    static int N;
    static String S;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int Onecount = 0;
    static int Twocount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = S.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    Onecount++;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'R') {
                    graph[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    Twocount++;
                    dfs(i, j);
                }
            }
        }
        System.out.printf("%d %d", Onecount, Twocount);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < N &&
                    y + dy[i] >= 0 && y + dy[i] < N && visited[x + dx[i]][y + dy[i]] == false
                    && graph[x + dx[i]][y + dy[i]] == graph[x][y]) {
                dfs(x + dx[i], y + dy[i]);
            }
        }

    }

}
