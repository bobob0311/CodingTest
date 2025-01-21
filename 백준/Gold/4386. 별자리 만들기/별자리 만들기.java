import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[2], o2[2]);
            }
        });

        int v = Integer.parseInt(br.readLine());

        double[][] map = new double[v + 1][2];
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            Double x = Double.parseDouble(st.nextToken());
            Double y = Double.parseDouble(st.nextToken());
            map[i][0] = x;
            map[i][1] = y;
        }

        for (int i = 1; i < v + 1; i++) {
            for (int j = i + 1; j < v + 1; j++) {
                double distX = Math.abs(map[i][0] - map[j][0]);
                double distY = Math.abs(map[i][1] - map[j][1]);
                double dist = Math.sqrt(distX * distX + distY * distY);

                pq.add(new double[] { i, j, dist });
            }
        }
        double answer = 0;
        while (!pq.isEmpty()) {
            double[] nowArr = pq.poll();
            int x = (int) nowArr[0];
            int y = (int) nowArr[1];
            double dist = nowArr[2];

            if (find(x) == find(y)) {
                continue;
            }
            answer += dist;
            union(x, y);
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