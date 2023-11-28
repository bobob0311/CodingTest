package CodingTest.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11277 {
    static int N, M;
    static boolean[] arr;
    static int[][] arr2;
    static int temp1, temp2;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new boolean[N + 1];
        arr2 = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Back();
        System.out.println(count);

    }

    static void Back() {
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                arr[i] = true;
                for (int j = 0; j < M; j++) {
                    temp1 = arr2[j][0];
                    temp2 = arr2[j][1];

                    if (temp1 < 0 && temp2 < 0) {
                        if (!arr[Math.abs(temp1)] == false && !arr[Math.abs(temp2)] == false) {
                            break;
                        }
                    } else if (temp1 < 0 && temp2 > 0) {
                        if (!arr[Math.abs(temp1)] == false && arr[temp2] == false) {
                            break;
                        }
                    } else if (temp1 > 0 && temp2 < 0) {
                        if (arr[temp1] == false && !arr[Math.abs(temp2)] == false) {
                            break;
                        }
                    } else {
                        if (arr[temp1] == false && arr[temp2] == false) {
                            break;
                        }
                    }
                    if (j == M - 1) {
                        count = 1;
                        return;
                    }
                }

                Back();
                arr[i] = false;
                visited[i] = false;
            }
        }
        return;
    }
}
