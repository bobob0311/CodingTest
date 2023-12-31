package BFS;
/*
 *미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, 
 (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
각각의 수들은 붙어서 입력으로 주어진다.


첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */

// 모든 노드를 지나갈 필요는 없고 DFS로 하는 것이 맞을듯 오른쪽 아래로 가야하는 것이 키포인트?
// 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2178 {
    static Queue<int[]> queue = new LinkedList<>();
    static int N, M;

    static int[][] count;

    static boolean[][] visited;
    static int[][] graph;
    static int dx[] = { 1, 0, 0, -1 };
    static int dy[] = { 0, 1, -1, 0 };

    static void bfs(int x, int y) {
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int X = arr[0];
            int Y = arr[1];
            for (int i = 0; i < 4; i++) {
                if (X + dx[i] >= 0 && X + dx[i] < N && Y + dy[i] >= 0 && Y + dy[i] < M &&
                        graph[X + dx[i]][Y + dy[i]] == 1 && !visited[X + dx[i]][Y + dy[i]]) {
                    visited[X + dx[i]][Y + dy[i]] = true;
                    count[X + dx[i]][Y + dy[i]] = count[X][Y] + 1;
                    queue.add(new int[] { X + dx[i], Y + dy[i] });
                    if (visited[N - 1][M - 1] == true) {
                        return;
                    }
                }

            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로의 수
        M = Integer.parseInt(st.nextToken()); // 가로의 수
        count = new int[N][M];
        visited = new boolean[N][M];
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                graph[i][j] = Character.getNumericValue(ch);
            }
        }

        count[0][0] = 1;
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(count[N - 1][M - 1]);

    }

}