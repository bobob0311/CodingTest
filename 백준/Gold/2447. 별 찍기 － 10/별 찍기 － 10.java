import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        chk = new boolean[n][n];
        star(0, n - 1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chk[i][j]) {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void star(int startX, int endX, int startY, int endY) {
        if (startX == endX && startY == endY) {
            chk[startX][startY] = true;
            return;
        }
        int size = ((endX - startX + 1) / 3);

        int[] stepX = new int[] { startX, startX + size, startX + size * 2 };
        int[] stepY = new int[] { startY, startY + size, startY + size * 2 };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    star(stepX[i], stepX[i] + size - 1, stepY[j], stepY[j] + size - 1);
                }
            }
        }

    }
}