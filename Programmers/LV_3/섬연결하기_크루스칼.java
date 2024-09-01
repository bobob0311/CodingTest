import java.util.*;

class Solution {
    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent, parent[x]);
    }

    static int cost = 0;

    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            pq.add(new int[] { c, a, b });
            pq.add(new int[] { c, b, a });
        }

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (find(parent, arr[1]) != find(parent, arr[2])) {
                cost += arr[0];
                union(parent, arr[1], arr[2]);
            }

        }

        return cost;
    }
}