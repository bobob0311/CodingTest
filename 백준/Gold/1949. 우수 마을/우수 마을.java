import java.util.*;
import java.io.*;

/*
1. 우수 마을 선정 주문 수의 총합을 최대 
2. 두마을이 인접해 있을 경우 두 마을이 모두 우수마을이 될 순ㄴ 없다
3. 우수 마을로 선정되지 못한 것은 적어도 하나아ㅢ 우수 마을과는 인접해야한다.

*/
public class Main {
    static int n;
    static int[] per;
    static List<List<Integer>> list;
    static int[][] dp;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        per = new int[n + 1];
        list = new ArrayList<>(n + 1);
        dp = new int[2][n + 1];
        chk = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            per[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        tree(1);

        System.out.println(Math.max(dp[0][1], dp[1][1]));
    }

    static void tree(int now) {
        // 여기가 우수에요~
        dp[0][now] = per[now];
        // 우수 아니에요..
        dp[1][now] = 0;
        chk[now] = true;

        for (Integer next : list.get(now)) {
            if (!chk[next]) {
                tree(next);
                // 내가 지금 우수니까 무조건 연결된건 다 우수가아니여야돼!!
                dp[0][now] += dp[1][next];
                // 내가 지금 우수 가아니니까 연결된건 우수이거나 우수가 아니여도돼
                dp[1][now] += Math.max(dp[0][next], dp[1][next]);
            }
        }
        chk[now] = false;
        return;
    }
}