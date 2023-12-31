package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1932 {
    static int[][] arr;
    static int N;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        temp = new int[N + 1];

        arr[0][0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + temp[j];

                } else if (j == i) {
                    arr[i][j] = arr[i - 1][j - 1] + temp[j];

                } else {

                    if (arr[i - 1][j] < arr[i - 1][j - 1]) {
                        arr[i][j] = arr[i - 1][j - 1] + temp[j];

                    } else {
                        arr[i][j] = arr[i - 1][j] + temp[j];
                    }
                }

            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < arr[N - 1][i]) {
                max = arr[N - 1][i];
            }
        }
        System.out.println(max);

    }
}
