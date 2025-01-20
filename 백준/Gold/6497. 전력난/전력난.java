import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        while (true) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int total = 0;
            int now = 0;
            if (v == 0 && e == 0) {
                break;
            }

            parent = new int[v + 1];
            for (int i = 1; i < v + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                total += w;
                pq.add(new int[] { start, end, w });
            }

            while (!pq.isEmpty()) {
                int[] nowArr = pq.poll();
                int v1 = nowArr[0];
                int v2 = nowArr[1];
                int w = nowArr[2];

                if (find(v1) != find(v2)) {
                    now += w;
                    union(v1, v2);
                }
            }
            System.out.println(total - now);

        }
    }

    static public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        } else {
            return parent[x];
        }
    }

    static public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }

}