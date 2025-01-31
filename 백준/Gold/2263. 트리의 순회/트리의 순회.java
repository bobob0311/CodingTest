import java.util.*;
import java.io.*;

/*
        1
    2       3
4     5   6    7

inoder :    4 2 5 1 6 3 7
postorder : 4 5 2 6 7 3 1
preorder :  1 2 4 5 3 6 7 


 */

public class Main {
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // left key right
        inOrder = new int[n];
        // left right key
        postOrder = new int[n];
        preOrder = new int[n];

        // key left right를 구해야한다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int nowNode = Integer.parseInt(st.nextToken());
            inOrder[i] = nowNode;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int nowNode = Integer.parseInt(st.nextToken());
            postOrder[i] = nowNode;
        }

        preOrder(0, n - 1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(preOrder[i] + " ");
        }
        System.out.println(sb.toString());
    }

    static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            preOrder[idx++] = postOrder[postEnd];

            int find = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == postOrder[postEnd]) {
                    find = i;
                    break;
                }
            }

            preOrder(inStart, find - 1, postStart, postStart + find - inStart - 1);
            preOrder(find + 1, inEnd, postStart + find - inStart, postEnd - 1);
        }

    }

}