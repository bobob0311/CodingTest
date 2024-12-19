import java.util.*;
import java.io.*;

public class Main {
    static boolean[] chk;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        chk = new boolean[N];
        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(N, 0, 0);
        System.out.println(min);

    }

    public static void dfs(int N, int next, int cnt) {
        if (cnt == N / 2) {
            min = Math.min(min, calc(N));
            return;
        }
        if(next >=N) return;
        
        for (int i = next; i < N; i++) {
            if (!chk[i]) {
                chk[i] = true;
                dfs(N, i + 1, cnt + 1);
                chk[i] = false;
            }
        }
    }

    public static int calc(int N) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (chk[i] && chk[j]) {
                    sum1 += map[i][j] + map[j][i];
                } else if (!chk[i] && !chk[j]) {
                    sum2 += map[i][j] + map[j][i];
                }
            }
        }

        return Math.abs(sum1 - sum2);
    }
}