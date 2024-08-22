import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            int[] target = road[i];
            int a = target[0];
            int b = target[1];
            int v = target[2];
            graph.get(a).add(new Node(b, v));
            graph.get(b).add(new Node(a, v));
        }

        boolean[] visited = new boolean[N + 1];

        int[] dist = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        visited[1] = true;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (int i = 0; i < graph.get(curNode.index).size(); i++) {
                Node nextNode = graph.get(curNode.index).get(i);
                if (dist[nextNode.index] > curNode.cost + nextNode.cost && visited[nextNode.index] == false) {
                    visited[nextNode.index] = true;
                    dist[nextNode.index] = curNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.index, dist[nextNode.index]));
                }

            }
        }
        int count = 0;
        for (int v : dist) {
            if (v <= K) {
                count++;
            }
        }

        return count;
    }

}