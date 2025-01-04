import java.util.*;
import java.io.*;

/*
N-Queen 
최대 15 X 15
 */

public class Main {
    static int[][] map;
    static int N;
    static int answer = 0;
    static boolean[] chk;
    static boolean[] right;
    static boolean[] left;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        chk = new boolean[N];
        right = new boolean[2 * N];
        left = new boolean[2 * N];
        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int count) {
        // 줄에 하나씩 넣었을때 체크
        if (count == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!chk[i] && !right[count - i + N] && !left[count + i]) {
                right[count - i + N] = true;
                left[count + i] = true;
                chk[i] = true;
                map[count][i] = 1;
                dfs(count + 1);
                map[count][i] = 0;
                chk[i] = false;
                right[count - i + N] = false;
                left[count + i] = false;
            }
        }

        return;
    }
}