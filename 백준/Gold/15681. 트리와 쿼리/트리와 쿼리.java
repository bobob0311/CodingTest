import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int root;
    static int queryCnt;
    static boolean[] chk;
    static List<Node> nodeList;
    static int[] answer;

    static class Node {
        List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        chk = new boolean[n + 1];
        nodeList = new ArrayList<>(n + 1);
        answer = new int[n + 1];

        root = Integer.parseInt(st.nextToken());
        queryCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            nodeList.add(new Node());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodeList.get(node1).list.add(node2);
            nodeList.get(node2).list.add(node1);
        }

        tree(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCnt; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(answer[query]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int tree(int idx) {
        chk[idx] = true;
        int cnt = 1;
        for (Integer next : nodeList.get(idx).list) {
            if (chk[next]) {
                continue;
            }
            cnt += tree(next);
        }
        return answer[idx] = cnt;
    }

}