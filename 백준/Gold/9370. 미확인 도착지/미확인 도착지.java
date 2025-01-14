import java.util.*;
import java.io.*;

/*
이 길을 지나가는 것이 최단 거리 인가를 체크하면 되는 거 같습니다.
1. 출발지에서 목표지까지 최단 거리를 구한다. 
2. 출발지에서 교차로 + 교차로 에서 목적지 까지의 거리 


*/

public class Main {
    static ArrayList<ArrayList<int[]>> list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 교차로
            n = Integer.parseInt(st.nextToken());
            // 도로
            int m = Integer.parseInt(st.nextToken());

            // 목적지 후보의 개수
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 출발지
            int s = Integer.parseInt(st.nextToken());

            // g와 h 교차로 사이에 있는 도로를 지나갔다?
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (g > h) {
                int temp = g;
                g = h;
                h = temp;
            }

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            int find = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list.get(a).add(new int[] { b, d });
                list.get(b).add(new int[] { a, d });

                if (a == g && b == h) {
                    find = d;
                }

            }

            int[] targetArr = new int[t];

            for (int i = 0; i < t; i++) {
                targetArr[i] = Integer.parseInt(br.readLine());
            }

            int[] startDist = new int[n + 1];
            int[] oneDist = new int[n + 1];
            int[] twoDist = new int[n + 1];

            boolean[] chk = new boolean[n + 1];

            Arrays.fill(startDist, Integer.MAX_VALUE);
            Arrays.fill(oneDist, Integer.MAX_VALUE);
            Arrays.fill(twoDist, Integer.MAX_VALUE);

            PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            da(s, startDist, chk, que);
            da(g, oneDist, chk, que);
            da(h, twoDist, chk, que);

            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < t; i++) {
                int target = targetArr[i];
                int part = Math.min(startDist[h] + oneDist[target], startDist[g] + twoDist[target]);

                if (startDist[target] == part + find) {
                    answer.add(target);
                }

            }

            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i) + " ");
            }
            System.out.println(sb.toString());

        }

    }

    static void da(int start, int[] dist, boolean[] chk, PriorityQueue<int[]> que) {
        dist[start] = 0;
        chk = new boolean[n + 1];
        que.add(new int[] { start, 0 });

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int nowNode = nowArr[0];
            int cost = nowArr[1];
            chk[nowNode] = true;

            for (int[] nextArr : list.get(nowNode)) {
                int nextNode = nextArr[0];
                int c = nextArr[1];
                int cal = cost + c;
                if (dist[nextNode] > cal) {
                    dist[nextNode] = cal;
                    que.add(new int[] { nextNode, cal });
                }
            }

        }
    }
}
