package problem;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int dist;

    Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {

        return dist - o.dist;
    }
}

public class 백준4485 {
    static int N, M;
    static List<ArrayList<Node>> nodeList;
    static final int INF = Integer.MAX_VALUE;
    static int[] distArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeList = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distArr = new int[N + 1];
        Arrays.fill(distArr, INF);

        for (int i = 0; i <= M * 2; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            nodeList.get(e).add(new Node(s, d));
            nodeList.get(s).add(new Node(e, d));
        }

        da(1, 0);
        System.out.println(distArr[N]);

    }

    static public void da(int dest, int total) {
        PriorityQueue<Node> que = new PriorityQueue<Node>();

        boolean[] chk = new boolean[N + 1];

        distArr[dest] = 0;
        que.offer(new Node(dest, 0));

        while (!que.isEmpty()) {
            Node queNode = que.poll();
            int start_node = queNode.end;

            if (!chk[start_node]) {
                chk[start_node] = true;

                for (Node node : nodeList.get(start_node)) {

                    if (!chk[node.end] && distArr[node.end] > (distArr[start_node] + node.dist)) {
                        distArr[node.end] = distArr[start_node] + node.dist;
                        que.offer(new Node(node.end, distArr[node.end]));
                    }
                }
            }
        }
        return;
    }
}
