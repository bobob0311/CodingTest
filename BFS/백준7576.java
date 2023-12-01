package CodingTest.BFS;

/*
철수 토마토 농장 토마토를 M N격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관중임
익은 토마토의 양옆과 위아래는 즉 인접한곳은 익은 토마토의 영향을 받아 익게된다.
혼자 저절로는 익지 않고 보관된 토마토들이 며칠이 지나야 다 익게 되는지 그 최소 일수를 알고 싶어한다.

!! 단 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

*/

/*
주어진 정보
1. M 상자의 가로 칸의수
2. N 상자의 세로칸의수 
 ( 2 <= M,N <= 1,000)

 3. 둘째줄 부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 
    M개의 정수로 주어짐 
    1 -> 익은 토마토
    0 -> 익지 않은 토마토
    -1 -> 토마토가 들어있지 않은 칸을 의미

4. 토마토가 하나이상 있는 경우만 입력으로 주어진다.


--->  출력
1. 모두 익을 때까지의 최소날 짜를 출력해야한다.
2. 시작부터 토마토가 모두 익어있으면 0을 출력
3. 토마토가 모두 익지 못하는 상황이면 -1

 */

/* 끝나는 상황
1. 모든 노드가 1 또는 -1 인경우
    모든 노드가 1인경우
    모든 노드가 -1 인경우
    1과 -1이 혼재하는 경우

2. 다른 노드를 방문 할 수 없는경우




출발점이 여러개가 될 수 있는데 ....
날짜를 세야하기 때문에 BFS가 맞다고 판단됨
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준7576 {
    static int M, N; // 가로,세로
    static int[][] graph; // 토마토가 담길 격자들
    static int[][] count; // 몇일째 되었는지
    static Queue<int[]> queue = new LinkedList<>(); // BFS를 구현하기 위한 Queue
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int no = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로의 수
        N = Integer.parseInt(st.nextToken()); // 세로의 수

        graph = new int[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        int[] arr;
        int x, y;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            arr = queue.poll();
            x = arr[0];
            y = arr[1];

            for (int k = 0; k < 4; k++) {
                if (x + dx[k] >= 0 && x + dx[k] < N &&
                        y + dy[k] >= 0 && y + dy[k] < M &&
                        graph[x + dx[k]][y + dy[k]] == 0) {

                    queue.add(new int[] { x + dx[k], y + dy[k] });
                    no++;
                    graph[x + dx[k]][y + dy[k]] = 1;
                    count[x + dx[k]][y + dy[k]] = count[x][y] + 1;
                }
            }

        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }

                if (count[i][j] > max) {
                    max = count[i][j];
                }
            }
        }
        return max;
    }
}
