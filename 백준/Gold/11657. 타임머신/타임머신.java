import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][3];
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[i] = new int[] { start, end, w };
        }

        dist[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[graph[j][0]] != Integer.MAX_VALUE) {
                    dist[graph[j][1]] = Math.min(dist[graph[j][1]], dist[graph[j][0]] + graph[j][2]);
                }
            }
        }

        boolean chk = false;
        for (int i = 0; i < M; i++) {
            if (dist[graph[i][0]] != Integer.MAX_VALUE && dist[graph[i][1]] > dist[graph[i][0]] + graph[i][2]) {
                chk = true;
                break;
            }
        }
        if (chk) {
            System.out.println("-1");
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("-1");
            }

        }

    }
}
