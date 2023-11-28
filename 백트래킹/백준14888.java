package CodingTest.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14888 {
    static int MAX = -1000000000;
    static int MIN = 1000000000;
    static int N; // 숫자의 개수 (2 ~ 11) (숫자의 범위는 1~100)
    static int[] arr;
    static int[] giho = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 총받아오는 숫자

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            giho[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (giho[i] > 0) {
                giho[i] -= 1;
                if (i == 0) {
                    dfs(num + arr[idx], idx + 1);
                }
                if (i == 1) {
                    dfs(num - arr[idx], idx + 1);
                }
                if (i == 2) {
                    dfs(num * arr[idx], idx + 1);
                }
                if (i == 3) {
                    dfs(num / arr[idx], idx + 1);
                }
                giho[i] += 1;
            }

        }

    }

}
