import java.util.*;
import java.io.*;
/*
1 -> 다익
N -> 다익
V1 -> 다익
 */

public class Main {
    static int[] answer;
    static ArrayList<ArrayList<int[]>> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        answer = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[] { end, w });
            list.get(end).add(new int[] { start, w });
        }
        st = new StringTokenizer(br.readLine());

        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());

        da(1);
        int startToV1 = answer[V1];
        int startToV2 = answer[V2];

        da(N);
        int endToV1 = answer[V1];
        int endToV2 = answer[V2];

        da(V1);
        int V1V2 = answer[V2];
        if (startToV1 == Integer.MAX_VALUE || startToV2 == Integer.MAX_VALUE || V1V2 == Integer.MAX_VALUE ||
                endToV1 == Integer.MAX_VALUE || endToV2 == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }

        if (startToV1 + endToV2 > startToV2 + endToV1) {
            System.out.println(startToV2 + endToV1 + V1V2);
        } else {
            System.out.println(startToV1 + endToV2 + V1V2);
        }
    }

    static void da(int start) {
        Arrays.fill(answer, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        boolean[] chk = new boolean[N + 1];
        answer[start] = 0;
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] nowArr = pq.poll();
            int nowNode = nowArr[0];
            int w = nowArr[1];
            chk[nowNode] = true;
            for (int[] nextArr : list.get(nowNode)) {
                int next = nextArr[0];
                int nextW = nextArr[1];
                if (!chk[next] && answer[next] > w + nextW) {
                    answer[next] = w + nextW;
                    pq.add(new int[] { next, w + nextW });
                }
            }
        }

    }
}
