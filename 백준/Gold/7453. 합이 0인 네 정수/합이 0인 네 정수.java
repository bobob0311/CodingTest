import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 두 배열의 합 저장
        int[] sum1 = new int[N * N];
        int[] sum2 = new int[N * N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1[idx] = A[i] + B[j];
                sum2[idx] = C[i] + D[j];
                idx++;
            }
        }

        // sum1과 sum2 정렬
        Arrays.sort(sum1);
        Arrays.sort(sum2);

        long cnt = 0;

        for (int value : sum1) {
            int lower = lowerBound(sum2, -value); // -value 이상
            int upper = upperBound(sum2, -value); // -value 초과
            cnt += (upper - lower); // 값이 일치하는 범위의 개수를 더함
        }

        System.out.println(cnt);
    }

    // lowerBound: target 이상인 첫 번째 위치
    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // upperBound: target 초과인 첫 번째 위치
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
