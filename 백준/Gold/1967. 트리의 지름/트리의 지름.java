import java.util.*;
import java.io.*;

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

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodeList.get(parent).add(child, w);
            nodeList.get(child).add(parent, w);
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