import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int nowTarget : target) {
            int lower = lowerBound(arr, nowTarget);
            int upper = upperBound(arr, nowTarget);
            bw.write((upper - lower) + " ");
        }
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int[] arr, int key) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upperBound(int[] arr, int key) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
