package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2559 {
    static int N, K;
    static int max = 0;
    static int[] arr;
    static int temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 숫자의 개수
        K = Integer.parseInt(st.nextToken()); // 연속되는 수

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            max += arr[i];
        }

        temp = max;

        for (int i = K; i < N; i++) {
            temp -= arr[i - K];
            temp += arr[i];

            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);

    }

}
