import java.util.*;
import java.io.*;

/*

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int w = arr[i][0];
            int v = arr[i][1];

            for (int j = K; j >= w; j--) {
                
                 answer[j] = Math.max(answer[j], v + answer[j-w]);
                
            }
        }
        int max = 0;
        for (int i = 0; i <= K; i++) {
            max = Math.max(answer[i], max);
        }
        System.out.println(max);

    }
}