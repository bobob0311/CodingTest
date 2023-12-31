package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11047 {
    static int N, K;
    static int[] arr;
    static int idx;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        idx = N - 1;

        while (K != 0) {
            if (arr[idx] <= K) {
                count += K / arr[idx];
                K %= arr[idx];
            }
            idx--;
        }

        System.out.println(count);
    }
}
