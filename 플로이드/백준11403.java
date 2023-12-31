package problem;

/*
가중치가 없는 방향 그래프 G
i->j로 가는 가중치가 있는가?

1은 있다는 뜻
0은 없다는 뜻
 */

import java.util.*;
import java.io.*;

public class 백준11403 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println("");
        }

    }
}
