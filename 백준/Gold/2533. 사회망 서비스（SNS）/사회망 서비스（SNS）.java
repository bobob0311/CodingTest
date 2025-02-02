import java.util.*;
import java.io.*;

/*
1. 자기 자신이 true인 경우 즉 얼리아답터인경우
    1-1 연결된 노드도 true
    1-2 연겨된 노드는 false
2. 자기 자신이 false인 경우 즉 얼리아답터가 아닌 경우
    => 무조건 연결된 노드는 true가 되어야 한다. 
 */

public class Main {
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] chk;
    static int[][] dp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        chk = new boolean[n + 1];
        int answer1 = tree(1, true);
        chk = new boolean[n + 1];
        int answer2 = tree(1, false);
        System.out.println(Math.min(answer1, answer2));
    }

    static int tree(int now, boolean flag) {
        chk[now] = true;
        int cnt;
        if (flag) {
            cnt = 1;
        } else {
            cnt = 0;
        }

        for (Integer next : list.get(now)) {
            if (chk[next]) {
                continue;
            } else {
                if (flag) {
                    int temp1;
                    int temp2;
                    if (dp[next][0] != -1) {
                        temp1 = dp[next][0];
                    } else {
                        temp1 = dp[next][0] = tree(next, flag);
                    }
                    if (dp[next][1] != -1) {
                        temp2 = dp[next][1];
                    } else {
                        temp2 = dp[next][1] = tree(next, !flag);
                    }
                    cnt += Math.min(temp1, temp2);
                } else {
                    if (dp[next][1] != -1) {
                        cnt += dp[next][0] = tree(next, !flag);
                    } else {
                        cnt += dp[next][0];
                    }

                }

            }
        }
        chk[now] = false;
        return cnt;

    }
}