package CodingTest.BFS;

/*
 N by M 행렬
 0은 이동 가능 1은 벽

 1,1 --> N,M으로 이동 근데 최단경로로 이동
 시작하는 칸과 끝나는 칸도 포함해서 센다
 이동중 한개의 벽을 부수고 이동하는ㄴ것이 더 짧아지면 벽을 한개까지 부수고 이동가능

 */

/*
모든 경우의 수를 해봐야할듯?
1. 그냥 그대로 갔을때 제일 짧은 경로
2. 한개 부셨을때 --> 모든 경우의 수를 다 해보자


BFS일것이다 왜냐하면 진행한칸한칸을 셀수 있기때문에 말로 설명하기에는 어렵넹
*/

import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 백준2206 {
    static int[][] graph;
    static boolean[][][] visited;

    static Queue<int[]> queue = new LinkedList<>();
    static int N, M;

    static int[][] count;
    static int[] da = { 1, -1, 0, 0 };
    static int[] db = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로의 수
        M = Integer.parseInt(st.nextToken()); // 가로의 수

        visited = new boolean[N + 1][M + 1][2];
        graph = new int[N + 1][M + 1];
        count = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char ch = str.charAt(j - 1);
                graph[i][j] = Character.getNumericValue(ch);
            }
        }

        bfs();

        if (N == 1 && M == 1) {
            System.out.print(1);
        } else {
            if (count[N][M] != 0) {
                System.out.print(count[N][M] + 1);
            } else {
                System.out.print(-1);
            }
        }

    }

    static void bfs() {
        queue.add(new int[] { 1, 1, 0 }); // 0이면 벽안부심, 1이면 하나 부시고왔음
        visited[1][1][0] = true;
        visited[1][1][1] = true;

        while (!queue.isEmpty() && count[N][M] == 0) {
            int[] arr = queue.poll();
            int a = arr[0]; // 세로
            int b = arr[1]; // 가로
            int c = arr[2]; // 부셨는지

            for (int i = 0; i < 4; i++) {
                int ad = a + da[i];
                int bd = b + db[i];

                if (ad >= 1 && ad <= N && bd >= 1 && bd <= M) {
                    if (graph[ad][bd] == 1 && c == 0) {
                        // 부셔야하는 경우인데 하나도 안부셔서 부실수있는경우
                        c++;
                        queue.add(new int[] { ad, bd, c });
                        count[ad][bd] = count[a][b] + 1;
                    }

                    if (graph[ad][bd] == 0) {
                        if (visited[ad][bd][c] == false) { // 0안부신거 1부신거
                            queue.add(new int[] { ad, bd, c });
                            visited[ad][bd][c] = true;
                            count[ad][bd] = count[a][b] + 1;
                        }
                    }

                }

            }

        }
    }
}