import java.io.*;
import java.util.*;

/*
N개의 수가 존재
수의 변경이 빈번하게 일어난다.
   0
  0 0
0 6 6 6

*/

public class Main {
    static int N, M, K;
    static long[] list;
    static StringTokenizer st;
    static long[] tree;
    static long[] sumTree; // lazy 배열로 사용
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new long[N + 1];
        tree = new long[4 * N];
        sumTree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            list[i] = Long.parseLong(br.readLine());
        }

        createTree(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (type == 1) {
                long val = Long.parseLong(st.nextToken());
                subAddValue(1, N, start, end, 1, val);
            } else {
                sb.append(subSum(1, N, start, end, 1)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    static long createTree(int left, int right, int node) {
        if (left == right) {
            return tree[node] = list[left];
        }

        int mid = (left + right) / 2;
        tree[node] = createTree(left, mid, node * 2) + createTree(mid + 1, right, node * 2 + 1);
        return tree[node];
    }

    static void lazyUpdate(int left, int right, int node) {
        if (sumTree[node] == 0) return;

        tree[node] += (right - left + 1L) * sumTree[node];

        if (left != right) {
            sumTree[node * 2] += sumTree[node];
            sumTree[node * 2 + 1] += sumTree[node];
        }

        sumTree[node] = 0;
    }

    static void subAddValue(int left, int right, int start, int end, int node, long value) {
        lazyUpdate(left, right, node);

        if (end < left || right < start) return;

        if (start <= left && right <= end) {
            sumTree[node] += value;
            lazyUpdate(left, right, node);
            return;
        }

        int mid = (left + right) / 2;

        subAddValue(left, mid, start, end, node * 2, value);
        subAddValue(mid + 1, right, start, end, node * 2 + 1, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long subSum(int left, int right, int start, int end, int node) {
        lazyUpdate(left, right, node);

        if (end < left || right < start) return 0;

        if (start <= left && right <= end) {
            return tree[node];
        }

        int mid = (left + right) / 2;

        return subSum(left, mid, start, end, node * 2)
                + subSum(mid + 1, right, start, end, node * 2 + 1);
    }
}