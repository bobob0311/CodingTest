import java.io.*;
import java.util.StringTokenizer;

/*
전체 종이가 같은 색이 아니라면 4등분
모두 같은 색이거나 하나의 정사각형 칸이 될 때까지 반복
총 개수를 구해라 
*/

public class Main {
    static int[][] map;
    static int white = 0;
    static int blue = 0;

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
        rec(0, N, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void rec(int startX, int endX, int startY, int endY) {
        int target = map[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (map[i][j] != target) {
                    rec(startX, (startX + endX) / 2, startY, (startY + endY) / 2);
                    rec(startX, (startX + endX) / 2, (startY + endY) / 2, endY);
                    rec((startX + endX) / 2, endX, startY, (startY + endY) / 2);
                    rec((startX + endX) / 2, endX, (startY + endY) / 2, endY);
                    return;
                }
            }
        }

        if (target == 0) {
            white++;
        } else {
            blue++;
        }
        return;
    }
}