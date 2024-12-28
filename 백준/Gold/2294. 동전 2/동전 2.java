import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[k + 1];
        Arrays.sort(answer);

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                answer[arr[i]] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            for (int j = now; j <= k; j++) {
                if (answer[j - now] == 0) {
                    continue;
                }
                if (answer[j] == 0) {
                    answer[j] = answer[j - now] + 1;
                } else {
                    answer[j] = Math.min(answer[j - now] + 1, answer[j]);
                }
            }
        }

        if (answer[k] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(answer[k]);
        }
    }
}