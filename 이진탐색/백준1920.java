package CodingTest.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1920 {

    static int N, M;
    static int[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        for (int i = 0; i < M; i++) {
            int target = arr2[i];
            gogo(0, N - 1, target);
        }

    }

    static void gogo(int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr1[mid] == target) {
                System.out.println(1);
                return;
            }

            if (arr1[mid] > target) {
                end = mid - 1;
            }
            if (arr1[mid] < target) {
                start = mid + 1;
            }

            if (start == end || end < start) {
                if (arr1[start] == target) {
                    System.out.println(1);
                    return;
                } else {
                    System.out.println(0);
                    return;
                }
            }

        }
    }
}
