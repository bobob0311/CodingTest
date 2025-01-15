import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> list = new ArrayList<>(n + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[] { end, w });
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int[] trace = new int[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[startNode] = 0;
        pq.add(new int[] { startNode, 0 });

        while (!pq.isEmpty()) {
            int[] nowArr = pq.poll();
            int nowNode = nowArr[0];
            if (chk[nowNode]) {
                continue;
            }
            int c = nowArr[1];
            chk[nowNode] = true;

            for (int[] nextArr : list.get(nowNode)) {
                int next = nextArr[0];
                int nextC = nextArr[1];
                if (!chk[next] && dist[next] > dist[nowNode] + nextC) {
                    dist[next] = dist[nowNode] + nextC;
                    pq.add(new int[] { next, c + nextC });
                    trace[next] = nowNode;
                }
            }
        }

        System.out.println(dist[endNode]);

        int temp = endNode;
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        while (temp != startNode) {
            cnt++;
            sb.insert(0, temp + " ");
            temp = trace[temp];
        }
        sb.insert(0, temp + " ");
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}