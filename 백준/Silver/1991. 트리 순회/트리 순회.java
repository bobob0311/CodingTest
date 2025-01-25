import java.util.*;
import java.io.*;

// 루트 노드는 1
public class Main {
    static List<Node> nodeList;
    static Queue<String> que;
    static Map<String, Integer> map;

    static class Node {
        String idx;
        String left;
        String right;

        Node(String me, String left, String right) {
            this.idx = me;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList<>(N);
        StringTokenizer st;
        que = new LinkedList<>();

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String idx = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            nodeList.add(new Node(idx, left, right));
            map.put(idx, i);
        }
        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    static void preOrder(String now) {
        if (now.equals(".")) {
            return;
        }
        Node nowNode = nodeList.get(map.get(now));
        System.out.print(nowNode.idx); 
        preOrder(nowNode.left);
        preOrder(nowNode.right);
    }

    static void inOrder(String now) {
        if (now.equals(".")) {
            return;
        }
        Node nowNode = nodeList.get(map.get(now));
        inOrder(nowNode.left);
        System.out.print(nowNode.idx);
        inOrder(nowNode.right);
    }

    static void postOrder(String now) {
        if (now.equals(".")) {
            return;
        }
        Node nowNode = nodeList.get(map.get(now));
        postOrder(nowNode.left);
        postOrder(nowNode.right);
        System.out.print(nowNode.idx);
    }
}