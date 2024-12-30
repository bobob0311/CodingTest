import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
                }

            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int answer = 0;

            for (int j = startX; j <= endX; j++) {
                answer += map[j][endY];
                if (startY == 0) {
                    continue;
                } else {
                    answer -= map[j][startY - 1];
                }

            }
            System.out.println(answer);
        }
    }
}