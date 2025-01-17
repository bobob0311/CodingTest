import java.util.*;
import java.io.*;

public class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] bus = new int[v + 1][v + 1];
        // i 에서 j를 가기위해 그 전에 k를 들린다?
        int[][] dp = new int[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(bus[i], INF);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (bus[start][end] > w) {
                bus[start][end] = w;
                dp[start][end] = start;
            }
        }

        for (int i = 1; i < v + 1; i++) {
            bus[i][i] = 0;
        }

        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (bus[i][k] != INF && bus[k][j] != INF && bus[i][j] > bus[i][k] + bus[k][j]) {
                        bus[i][j] = bus[i][k] + bus[k][j];
                        dp[i][j] = k;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (bus[i][j] == INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(bus[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        sb.setLength(0);

        for (int i = 1; i <= v; i++) {

            for (int j = 1; j <= v; j++) {
                if (i == j || bus[i][j] == INF) {
                    System.out.println(0);
                    continue;
                }
                int temp = j;
                int cnt = 1;
                while (temp != i) {
                    cnt++;
                    sb.insert(0, temp + " ");
                    temp = dp[i][temp];
                }
                sb.insert(0, temp + " ");
                System.out.println(cnt + " " + sb.toString());
                sb.setLength(0);
            }

        }
    }
}