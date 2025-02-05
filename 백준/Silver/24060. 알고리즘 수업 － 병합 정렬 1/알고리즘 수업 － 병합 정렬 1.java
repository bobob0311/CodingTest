import java.util.*;
import java.io.*;

/*
배열을 오름차순으로 정렬했을 때 K번째 저장되는 수를 구하자
 */

public class Main {
    static int[] arr;
    static int n;
    static int k;
    static int cnt = 0;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n - 1);

        System.out.println(answer);

    }

    static void merge_sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(start, mid);
            merge_sort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        int[] tmp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= end) {
            tmp[t++] = arr[j++];
        }

        i = start;
        t = 0;
        while (i <= end) {
            if (++cnt == k) {
                answer = tmp[t];
            }
            arr[i++] = tmp[t++];
        }
    }

}