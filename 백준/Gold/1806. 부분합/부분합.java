import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int len = 100001;
        int now = arr[0];

        while (start <= end) {
            if (now < S) {
                if (end >= N) {
                    break;
                }
                now += arr[end];
                end++;
            } else{
                len = Math.min(len, end - start);
                now -= arr[start];
                start++;
            }
        }

        if (len == 100001) {
            System.out.println(0);
        } else {
            System.out.println(len);
        }

    }
}