package Programmers.고득점kit.완전탐색;

import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static int _min = 9999;

    public int solution(int n, int[][] wires) {

        for (int i = 1; i < n + 1; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            adjList.get(u).remove(Integer.valueOf(v));
            adjList.get(v).remove(Integer.valueOf(u));
            bfs(n);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return _min;
    }

    static void bfs(int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        int count = 0;
        visited[1] = true;

        while (!que.isEmpty()) {
            int node = que.poll();
            count++;
            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    que.add(adj);
                    visited[adj] = true;

                }
            }
        }
        _min = Math.min(_min, Math.abs(count - (n - count)));

        return;
    }
}
