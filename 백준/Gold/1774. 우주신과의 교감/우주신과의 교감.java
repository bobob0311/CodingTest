import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[2], o2[2]);
            }
        });

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] map = new int[v + 1][2];
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 좌표 받기
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        // 연결되어있는것들 연결
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());
            pq.add(new double[] { o1, o2, 0 });
        }

        while (!pq.isEmpty()) {
            double[] nowArr = pq.poll();
            int o1 = (int) nowArr[0];
            int o2 = (int) nowArr[1];

            if (find(o1) != find(o2)) {
                union(o1, o2);
            }
        }

        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                double dist = Math.sqrt(Math.pow((map[i][0] - map[j][0]), 2) + Math.pow((map[i][1] - map[j][1]), 2));
                pq.add(new double[] { i, j, dist });
            }
        }

        double answer = 0;
        while (!pq.isEmpty()) {
            double[] nowArr = pq.poll();
            int o1 = (int) nowArr[0];
            int o2 = (int) nowArr[1];
            double dist = nowArr[2];
            if (find(o1) != find(o2)) {
                union(o1, o2);
                answer += dist;
            }
        }

        System.out.printf("%.2f", answer);

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}