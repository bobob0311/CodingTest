import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static int N;
    static int H;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> que = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        boolean[][][] chk = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int now = Integer.parseInt(st.nextToken());
                    box[i][j][k] = now;
                    if (now == 1) {
                        que.add(new int[] { i, j, k, 0 });
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int h = nowArr[0];
            int n = nowArr[1];
            int m = nowArr[2];
            int count = nowArr[3];

            answer = Math.max(answer, count);

            int[][] cond = new int[][] { { h + 1, n, m }, { h - 1, n, m }, { h, n + 1, m }, { h, n - 1, m },
                    { h, n, m + 1 }, { h, n, m - 1 } };

            for (int[] con : cond) {
                int nowH = con[0];
                int nowN = con[1];
                int nowM = con[2];
                if (check(nowH, nowN, nowM) && box[nowH][nowN][nowM] == 0 && !chk[nowH][nowN][nowM]) {
                    box[nowH][nowN][nowM] = 1;
                    chk[nowH][nowN][nowM] = true;
                    que.add(new int[] { nowH, nowN, nowM, count + 1 });
                }
            }

        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(int h, int n, int m) {
        if (h >= 0 && h < H && m >= 0 && m < M && n < N && n >= 0) {
            return true;
        } else {
            return false;
        }
    }
}