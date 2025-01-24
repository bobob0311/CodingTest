import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0, 0);
    }

    static void dfs(int[][] map, int row, int col) {
        if (col == 9) {
            dfs(map, row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (chk(map, row, col, i)) {
                    map[row][col] = i;
                    dfs(map, row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }
        dfs(map, row, col + 1);

    }

    static boolean chk(int[][] map, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}