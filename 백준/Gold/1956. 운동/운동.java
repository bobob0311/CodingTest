import java.util.*;
import java.io.*;

/* 
사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾아라 

*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] map = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[start][end] = w;
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
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

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                } else {
                    int line1 = map[i][j];
                    int line2 = map[j][i];
                    if (line1 == Integer.MAX_VALUE || line2 == Integer.MAX_VALUE) {
                        continue;
                    } else {
                        answer = Math.min(answer, line1 + line2);
                    }
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }

    }
}
