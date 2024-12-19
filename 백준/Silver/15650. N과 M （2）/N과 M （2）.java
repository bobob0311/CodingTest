import java.util.*;
import java.io.*;

public class Main {
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chk = new boolean[N + 1];
        dfs(N, M, "", 0, 1);

    }

    public static void dfs(int N, int M, String now, int cnt, int next) {
        if (cnt == M) {
            System.out.println(now);
            return;
        }
        for (int i = next; i <= N; i++) {
            if (chk[i] == false) {
                chk[i] = true;
                dfs(N, M, now + i + " ", cnt + 1, i + 1);
                chk[i] = false;
            } else {
                continue;
            }
        }
        return;
    }
}