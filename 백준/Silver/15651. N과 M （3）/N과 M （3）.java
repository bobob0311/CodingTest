import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();

        dfs(N, M, new StringBuilder(), 0, result);

        System.out.println(result);

    }

    public static void dfs(int N, int M, StringBuilder current, int cnt, StringBuilder result) {
        if (cnt == M) {
            result.append(current).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            current.append(i).append(" ");
            dfs(N, M, current, cnt + 1, result);
            current.setLength(current.length() - 2);
        }
        return;
    }
}