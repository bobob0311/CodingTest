import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준24479 {
    static int count = 0;
    static int N, M, R;
    static boolean[] visit;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static Queue<Integer> queue = new LinkedList<>();

    static int a, b;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph[a][b] = 1;
        }

        dfs(R);
        int count = 1;
        while (!queue.isEmpty()) {
            int target = queue.poll();
            result[target] = count;
            count++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }

    }

    static void dfs(int start) {
        queue.add(start);
        result[start] = count++;
        for (int i = 1; i <= graph[start].length; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i);
            }
        }

    }

}
