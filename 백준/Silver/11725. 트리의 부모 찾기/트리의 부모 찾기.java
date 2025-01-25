import java.util.*;
import java.io.*;

// 루트 노드는 1
public class Main {
    static class Node {
        int idx;
        List<Integer> list = new ArrayList<>();

        Node(int idx) {
            this.idx = idx;
        }

        public void add(int node) {
            list.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> nodeList = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            nodeList.add(new Node(i));
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodeList.get(node1).add(node2);
            nodeList.get(node2).add(node1);
        }

        que.add(1);

        boolean[] chk = new boolean[N + 1];
        chk[1] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            chk[now] = true;

            for (int next : nodeList.get(now).list) {
                if (chk[next]) {
                    continue;
                } else {
                    if (dp[next] == 0) {
                        dp[next] = now;
                        que.add(next);
                        chk[next] = true;
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(dp[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}