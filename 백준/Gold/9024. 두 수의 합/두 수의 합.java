import java.util.*;
import java.io.*;
/*

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            // 숫자의 개수
            int n = Integer.parseInt(st.nextToken());
            // 목표 target
            int target = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            // 위아래 몇 되는지 찾기
            int min = Integer.MAX_VALUE;

            int start = 0;
            int end = n - 1;

            while (start < end) {
                int now = arr[start] + arr[end];
                if (now == target) {
                    min = 0;
                    break;
                } else {
                    int abs = Math.abs(target - now);
                    min = Math.min(abs, min);
                    if (now > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            int cnt = 0;
            // 투포인터로 찾기
            if (min == 0) {
                cnt += binarySerach(arr, 0, n - 1, target);
            } else {
                cnt += binarySerach(arr, 0, n - 1, target + min);
                cnt += binarySerach(arr, 0, n - 1, target - min);
            }

            System.out.println(cnt);
        }
    }

    static int binarySerach(int[] arr, int start, int end, int target) {
        int cnt = 0;
        while (start < end) {
            int now = arr[start] + arr[end];
            if (now == target) {
                cnt++;
                start++;
                end--;
            } else {
                if (now > target) {
                    end--;
                } else {
                    start++;
                }
            }

        }
        return cnt;
    }
}