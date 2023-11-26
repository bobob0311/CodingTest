package CodingTest.TwoPointer;

// 그냥 어거지 느낌인데 ㅎㅎ;;;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1253 {
    static int N;
    static int[] arr;
    static int idx;
    static int count;
    static int target, idx1, idx2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 숫자의 개수

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            target = arr[i];
            idx1 = 0;
            idx2 = 1;
            while (idx1 < N - 1) {
                if (idx1 == i) {
                    idx1++;
                    idx2 = idx1 + 1;
                    continue;
                }
                if (idx2 == i) {
                    idx2++;
                }

                if (idx2 >= N || arr[idx1] + arr[idx2] > target) {
                    idx1++;
                    idx2 = idx1 + 1;
                    continue;
                }

                if (arr[idx1] + arr[idx2] == target) {
                    count++;
                    break;
                }

                if (arr[idx1] + arr[idx2] < target) {
                    idx2++;
                }

            }

        }
        System.out.println(count);

    }
}
