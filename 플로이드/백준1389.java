package 플로이드;

import java.util.*;
import java.io.*;

/*
1:        N(2~100) 유저의수  /  M(1~5000) 친구 관계의 수
2~M+1:    A  B   (A와 B가 친구라는 뜻)
 */

public class 백준1389 {
    static int N, M;
    static int[][] dist;
    static int[] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = (i == j) ? 0 : 5000000;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // for (int i = 1; i <= N; i++) {
        // for (int j = 1; j <= N; j++) {
        // System.out.print(dist[i][j]);

        // }
        // System.out.println("");
        // }

        // System.out.println("");

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        // for (int i = 1; i <= N; i++) {
        // for (int j = 1; j <= N; j++) {
        // System.out.print(dist[i][j]);

        // }
        // System.out.println("");
        // }

        for (int i = 1; i < N + 1; i++) {
            int temp = 0;
            for (int j = 1; j < N + 1; j++) {
                temp += dist[i][j];
            }
            res[i] = temp;
        }
        int target = 0;
        int min = 100000;
        for (int i = 1; i < N + 1; i++) {
            if (res[i] < min) {
                min = res[i];
                target = i;
            }
        }
        System.out.println(target);

    }
}
