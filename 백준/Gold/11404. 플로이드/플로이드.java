import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[V + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (map[start][end] == Integer.MAX_VALUE) {
                map[start][end] = w;
            } else {
                if (map[start][end] > w) {
                    map[start][end] = w;
                }
            }

        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int now = map[i][k] + map[k][j];
                    if (now < map[i][j]) {
                        map[i][j] = now;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    sb.append("0 ");
                } else {
                    if (map[i][j] == Integer.MAX_VALUE) {
                        sb.append("0 ");
                    } else {
                        sb.append(map[i][j] + " ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
