import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> que = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        que.add(new int[] { start, 0 });

        int[] answer = new int[100001];
        boolean[] chk = new boolean[100001];

        while (!que.isEmpty()) {
            int[] nowArr = que.poll();
            int now = nowArr[0];
            if (now == target) {
                System.out.println(nowArr[1]);
                break;
            }
            int nowCnt = nowArr[1];
            chk[now] = true;
            if (now - 1 >= 0 && !chk[now - 1]) {
                chk[now - 1] = true;
                que.add(new int[] { now - 1, nowCnt + 1 });
                answer[now - 1] = now;
            }
            if (now + 1 <= 100000 && !chk[now + 1]) {
                chk[now + 1] = true;
                que.add(new int[] { now + 1, nowCnt + 1 });
                answer[now + 1] = now;
            }
            if (now * 2 <= 100000 && !chk[now * 2]) {
                chk[now * 2] = true;
                que.add(new int[] { now * 2, nowCnt + 1 });
                answer[now * 2] = now;
            }
        }
        int temp = target;
        while (temp != start) {
            stk.add(temp);
            temp = answer[temp];
        }
        stk.add(start);
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}