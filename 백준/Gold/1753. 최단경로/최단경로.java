import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            };
        });

        // 정점의 개수
        int V = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        int[] answer = new int[V + 1];
        boolean[] chk = new boolean[V + 1];

        Arrays.fill(answer, Integer.MAX_VALUE);

        List<ArrayList<int[]>> map = new ArrayList<>(V + 1);
        answer[start] = 0;
        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(startNode).add(new int[] { endNode, w });
        }

        pq.add(new int[] { start, 0 });
        while (!pq.isEmpty()) {
            int[] nowArr = pq.poll();
            int nowNode = nowArr[0];
            int nowW = nowArr[1];
            chk[nowNode] = true;

            for (int[] info : map.get(nowNode)) {
                int next = info[0];
                int w = info[1];
                if (!chk[next] && nowW + w < answer[next]) {
                    answer[next] = nowW + w;
                    pq.add(new int[] { next, nowW + w });
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(answer[i] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
