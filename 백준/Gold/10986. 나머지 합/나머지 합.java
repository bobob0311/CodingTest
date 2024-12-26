import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] sum = new long[N];
        long[] answer = new long[M];
        long cnt = 0;
        sum[0] = arr[0];
        answer[(int) sum[0] % M]++;

        for (int i = 1; i < N; i++) {
            long now = sum[i - 1] + arr[i];
            now %= M;
            sum[i] = now;
            answer[(int) now]++;
        }
        // 0 부터 했을 때
        cnt += answer[0];

        for (int i = 0; i < M; i++) {
            long now = answer[i];
            if (now > 1) {
                cnt += (now * (now - 1)) / 2;
            }

        }

        System.out.println(cnt);

    }
}