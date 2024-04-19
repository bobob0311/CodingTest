package SW기출;

import java.util.*;
import java.io.*;

/*
상담을 완료하는데 걸리는 기간(Ti)과 상담을 했을 때 받을 수 있는 금액(Pi)

N은 1~15
Ti 1~5
Pi 1~1000

최대 나올 수 있는 금액은 1000 * 15 /1 = 15000;
 */
public class 백준14501 {
    static int N;
    static int[][] arr;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        dfs(0, 0);
        System.out.println(result);

    }

    static void dfs(int now, int money) {
        if (now >= N) {
            result = Math.max(result, money);
            return;
        }


        
        if (now + arr[now][0] <= N) {
            dfs(now + arr[now][0], money + arr[now][1]);
        } else {
            dfs(now + arr[now][0], money);
        }

        dfs(now + 1, money);

    }
}
