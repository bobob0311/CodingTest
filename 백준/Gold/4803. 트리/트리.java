import java.util.*;
import java.io.*;

/*
루트가 하나여야 한다. 
사이클이 없어야한다.
n-1개의 간선
 */
public class Main {
    static class Node {
        List<Integer> list = new ArrayList<>();

        public void add(int o) {
            list.add(o);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 0;
        while (true) {
            caseNum++;
            st = new StringTokenizer(br.readLine());
            // 정점의 개수
            int n = Integer.parseInt(st.nextToken());
            // 간선의 개수
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            List<Node> nodeList = new ArrayList<>(n + 1);
            for (int i = 0; i < n + 1; i++) {
                nodeList.add(new Node());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                nodeList.get(node1).add(node2);
                nodeList.get(node2).add(node1);
            }

            boolean[] chk = new boolean[n + 1];
            int cnt = 0;
            Queue<Integer> que = new LinkedList<>();
            for (int i = 1; i < n + 1; i++) {
                if (!chk[i]) {
                    que.add(i);
                    chk[i] = true;
                }
                int mCnt = 0;
                int nodeCnt = 0;
                while (!que.isEmpty()) {
                    int now = que.poll();
                    nodeCnt++;
                    for (int nextNode : nodeList.get(now).list) {
                        mCnt++;
                        if (chk[nextNode]) {
                            continue;
                        } else {
                            chk[nextNode] = true;
                            que.add(nextNode);
                        }
                    }
                }
                if ((mCnt / 2) == nodeCnt - 1) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.printf("Case %d: No trees.\n", caseNum);
            } else if (cnt == 1) {
                System.out.printf("Case %d: There is one tree.\n", caseNum);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", caseNum, cnt);
            }
        }
    }
}