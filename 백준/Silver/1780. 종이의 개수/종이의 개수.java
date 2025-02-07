import java.util.*;
import java.io.*;

public class Main {
    static int minusCnt = 0;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(0, N, 0, N);
        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    static void sol(int startX, int endX, int startY, int endY) {
        int target = map[startX][startY];
        boolean chk = false;
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (target != map[i][j]) {
                    chk = true;
                    break;
                }
            }
        }
        if (chk) {
            int size = (endX - startX) / 3;
            int[] arrX = new int[] { startX, startX + size, startX + 2 * size };
            int[] arrY = new int[] { startY, startY + size, startY + 2 * size };
            for (int x : arrX) {
                for (int y : arrY) {
                    sol(x, x + size, y, y + size);
                }
            }

        } else {
            if (target == -1) {
                minusCnt++;
            } else if (target == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

    }

}