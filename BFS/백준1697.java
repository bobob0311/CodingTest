package BFS;

// N 수빈위치
// K 동생위치 
// 1초 후에 X-1   X+1    2 * X 3가지 케이스 가능
// 몇초뒤에 동생위치로 갈수있는가?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1697 {
    static int N, M;
    static int[] count = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로의 수
        M = Integer.parseInt(st.nextToken()); // 가로의 수

        bfs(N);

    }

    static void bfs(int n) {
        queue.add(n);
        count[n] = 0;

        if (n == M) {
            System.out.print(0);
            return;
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x + 1 <= 100000 && visited[x + 1] == false) {
                count[x + 1] = count[x] + 1;
                queue.add(x + 1);
                visited[x + 1] = true;
            }

            if (x - 1 >= 0 && visited[x - 1] == false) {
                count[x - 1] = count[x] + 1;
                queue.add(x - 1);
                visited[x - 1] = true;
            }

            if (x * 2 <= 100000 && visited[x * 2] == false) {
                count[x * 2] = count[x] + 1;
                queue.add(x * 2);
                visited[x * 2] = true;
            }

            if (x + 1 == M) {
                System.out.println(count[x + 1]);
                return;
            }
            if (x - 1 == M) {
                System.out.println(count[x - 1]);
                return;
            }
            if (x * 2 == M) {
                System.out.println(count[x * 2]);
                return;
            }

        }

    }

}
