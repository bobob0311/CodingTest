import java.util.*;

class Solution {

    static class Edge {
        int to, type;
        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    static ArrayList<Edge>[] graph;
    static int n, k, answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        answer = 1;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int type = e[2];

            graph[a].add(new Edge(b, type));
            graph[b].add(new Edge(a, type));
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, infected);

        return answer;
    }

    static void dfs(int step, boolean[] infected) {
        

        if (step == k) {
            answer = Math.max(answer, count(infected));
            return;
        }

        for (int type = 1; type <= 3; type++) {
            boolean[] next = spread(infected, type);
            dfs(step + 1, next);
        }
    }

    static boolean[] spread(boolean[] infected, int type) {
        boolean[] next = infected.clone();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (next[i]) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Edge edge : graph[now]) {
                if (edge.type != type) continue;
                if (next[edge.to]) continue;

                next[edge.to] = true;
                q.offer(edge.to);
            }
        }

        return next;
    }

    static int count(boolean[] infected) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) cnt++;
        }
        return cnt;
    }
}