import java.util.*;
import java.io.*;

// 루트를 찾는 방법이 중요한듯?
// 아니면 그냥 가장 긴 루트를 찾을 수 있는가?
// 루트를 찾을 수는 있는가?

// 십억이요.
public class Main {
    static class Node {
        int idx;
        List<int[]> list = new ArrayList<>();

        Node(int idx) {
            this.idx = idx;
        }

        public void add(int node, int w) {
            list.add(new int[] { node, w });
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        List<Node> nodeList = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            nodeList.add(new Node(i));
        }

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            while (true) {
                int o2 = Integer.parseInt(st.nextToken());
                if (o2 == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());

                nodeList.get(o1).add(o2, w);
            }
        }

        boolean[] visited = new boolean[N + 2];
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 1, 0 });
        visited[1] = true;
        int farIdx = 1;

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int nowNode = nowArr[0];
            int nowDist = nowArr[1];

            for (int[] next : nodeList.get(nowNode).list) {
                int nextNode = next[0];
                int w = next[1];
                if (visited[nextNode]) {
                    continue;
                } else {
                    visited[nextNode] = true;
                    int nextDist = nowDist + w;
                    que.add(new int[] { nextNode, nextDist });
                    if (answer < nextDist) {
                        answer = nextDist;
                        farIdx = nextNode;
                    }
                }
            }
        }

        visited = new boolean[N + 1];
        answer = 0;
        que.add(new int[] { farIdx, 0 });
        visited[farIdx] = true;

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int nowNode = nowArr[0];
            int nowDist = nowArr[1];

            for (int[] next : nodeList.get(nowNode).list) {
                int nextNode = next[0];
                int w = next[1];
                if (visited[nextNode]) {
                    continue;
                } else {
                    visited[nextNode] = true;
                    int nextDist = nowDist + w;
                    que.add(new int[] { nextNode, nextDist });
                    answer = Math.max(answer, nextDist);
                }
            }
        }

        System.out.println(answer);

    }
}