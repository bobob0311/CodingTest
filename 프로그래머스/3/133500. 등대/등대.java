import java.util.*;

class Solution {
    static int[][] dp;
    static boolean[] visited;  

    public int solution(int n, int[][] lighthouse) {
        List<List<Integer>> list = new ArrayList<>();
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] now : lighthouse) {
            list.get(now[0]).add(now[1]);
            list.get(now[1]).add(now[0]);
        }

        dfs(1, -1, list);

        return Math.min(dp[1][0], dp[1][1]); 
    }

    static void dfs(int node, int parent, List<List<Integer>> list) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;

        for (Integer child : list.get(node)) {
            if (visited[child]) continue; 

            dfs(child, node, list);

            dp[node][0] += dp[child][1];  
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
