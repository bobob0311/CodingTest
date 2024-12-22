import java.util.*;
import java.io.*;

/*
1를 더한다
3을 곱한다
2를 곱한다
*/

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[] chk = new boolean[n + 1];
        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            return;
        }
        if (n == 3) {
            System.out.println(1);
            return;
        }

        arr[2] = 1;
        arr[3] = 1;
        que.add(2);
        que.add(3);

        while (!que.isEmpty()) {
            int now = que.poll();
            if (chk[now]) {
                continue;
            }
            chk[now] = true;
            if (now * 2 < n + 1 && arr[now * 2] == 0) {
                arr[now * 2] = arr[now] + 1;
                que.add(now * 2);
            }
            if (now * 3 < n + 1 && arr[now * 3] == 0) {
                arr[now * 3] = arr[now] + 1;
                que.add(now * 3);
            }
            if (now + 1 < n + 1 && arr[now + 1] == 0) {
                arr[now + 1] = arr[now] + 1;
                que.add(now + 1);
            }
        }

        System.out.println(arr[n]);
    }
}