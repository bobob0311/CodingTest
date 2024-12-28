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

        answer[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                answer[j] += answer[j - arr[i]];
            }
        }
        System.out.println(answer[k]);
    }
}