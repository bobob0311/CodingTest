import java.util.*;

class Solution {
    class Node {
        List<Integer> neighbors = new ArrayList<>();
        long value;
        Node(long value) {
            this.value = value;
        }
    }

    List<Node> tree;
    long answer = 0;

    public long solution(int[] a, int[][] edges) {
        tree = new ArrayList<>(a.length);
        long total = 0;


        for (int i = 0; i < a.length; i++) {
            tree.add(new Node(a[i]));
            total += a[i];
        }


        if (total != 0) {
            return -1;
        }


        for (int[] edge : edges) {
            tree.get(edge[0]).neighbors.add(edge[1]);
            tree.get(edge[1]).neighbors.add(edge[0]);
        }


        dfs(0, -1);

        return answer;
    }

    private void dfs(int current, int parent) {
        Node currentNode = tree.get(current);


        for (int i=0; i<currentNode.neighbors.size(); i++) {
            int neighbor = currentNode.neighbors.get(i);
            if (neighbor != parent) {
                dfs(neighbor, current);

                Node childNode = tree.get(neighbor);

                currentNode.value += childNode.value;

                answer += Math.abs(childNode.value);
            }
        }
    }
}
