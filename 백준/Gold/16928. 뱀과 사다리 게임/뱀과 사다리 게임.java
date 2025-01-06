import java.util.*;
import java.io.*;

/*
10 * 10
1 ~ 100의 수

주사위 만크 이동
100번 칸 넘어가면 끝

사다리는 올라가
뱀은 내려가

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start] = end;
        }

        Queue<int[]> que = new LinkedList<>();
        boolean[] chk = new boolean[101];
        que.add(new int[] { 1, 0 });

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int now = nowArr[0];
            if (arr[now] != 0) {
                now = arr[now];
            }
            int count = nowArr[1];
            if (now == 100) {
                System.out.println(count);
                return;
            }

            // if (arr[now] != 0) {
            // if (!chk[arr[now]]) {
            // chk[arr[now]] = true;
            // que.add(new int[] { arr[now], count + 1 });
            // }
            // }
            for (int i = 1; i <= 6; i++) {
                if (now + i <= 100 && !chk[now + i]) {
                    chk[now + i] = true;
                    que.add(new int[] { now + i, count + 1 });
                }
            }

        }

    }
}