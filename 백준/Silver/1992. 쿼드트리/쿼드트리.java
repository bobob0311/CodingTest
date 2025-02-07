import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        String input = "";
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        sol(0, N, 0, N);
        System.out.println(sb.toString());

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
            int size = (endX - startX) / 2;
            sb.append("(");
            sol(startX, startX + size, startY, startY + size);
            sol(startX, startX + size, startY + size, endY);
            sol(startX + size, endX, startY, startY + size);
            sol(startX + size, endX, startY + size, endY);
            sb.append(")");
        } else {
            sb.append(target);
        }

    }

}