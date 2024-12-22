import java.io.*;
import java.util.*;

/*
모두 0 보다 작거나 같으면 1

하나라도 20보다 크면 w(20,20,20)

a<b<c이면
w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)

else
w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
*/

public class Main {
    static int[][][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[21][21][21];
        arr[0][0][0] = 1;
        StringBuilder sb=new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int cnt = w(a, b, c);
            sb.append("w(")
                    .append(a)
                    .append(", ")
                    .append(b)
                    .append(", ")
                    .append(c)
                    .append(") = ")
                    .append(cnt);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a <= 20 && b <= 20 && c <= 20 && arr[a][b][c] != 0) {
            return arr[a][b][c];
        } else {
            if (a > 20 || b > 20 || c > 20) {
                a = 20;
                b = 20;
                c = 20;
                return arr[20][20][20] = w(20, 20, 20);
            } else if (a < b && b < c) {
                return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            } else {
                return arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            }
        }

    }
}