import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            Node now = root;
            while (true) {

                if (now.key > num) {
                    if (now.left == null) {
                        now.left = new Node(num);
                        break;
                    }
                    now = now.left;
                } else {
                    if (now.right == null) {
                        now.right = new Node(num);
                        break;
                    }
                    now = now.right;
                }
            }
        }

        order(root);
        System.out.println(sb.toString());
    }

    static void order(Node root) {
        if (root == null)
            return;
        order(root.left);
        order(root.right);
        sb.append(root.key).append("\n");
    }
}