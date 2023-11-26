
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준2606 {
    static int first;
    static int num;
    static int[][] graph;
    static int a, b;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int target;
    static int count;

    static void bfs(int x) {
        visited[x] = true;
        queue.add(x);
        while (!queue.isEmpty()) {
            target = queue.poll();
            for (int i = 1; i <= first; i++) {
                if (graph[target][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count += 1;
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        first = sc.nextInt();
        num = sc.nextInt();
        graph = new int[first + 1][first + 1];
        visited = new boolean[first + 1];
        count = 0;
        for (int i = 0; i < num; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;

        }
        bfs(1);
        System.out.println(count);
    }
}
