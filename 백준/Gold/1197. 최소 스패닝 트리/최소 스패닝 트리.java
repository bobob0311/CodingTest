import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new int[] { start, end, w });
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int start = now[0];
            int end = now[1];
            int w = now[2];

            if (find(start) != find(end)) {
                answer += w;
                union(start, end);
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }

    }
}