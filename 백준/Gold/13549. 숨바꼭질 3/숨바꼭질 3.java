import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // cnt 기준 정렬

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[120001];
        que.add(new int[] { start, 0 });
        chk[start] = true;
        int min = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int now = nowArr[0];
            chk[now] = true;
            int cnt = nowArr[1];

            if (now == target) {
                min = Math.min(min, cnt);
            }

            if (now * 2 < 120000) {
                int next = now * 2;
                if (!chk[next]) {
                    que.add(new int[] { next, cnt });
                }
            }

            int[] cond = new int[] { now + 1, now - 1 };
            for (int c : cond) {
                if (c >= 0 && c <= 120000 && !chk[c]) {
                    que.add(new int[] { c, cnt + 1 });
                }
            }
        }
        System.out.println(min);
    }
}
