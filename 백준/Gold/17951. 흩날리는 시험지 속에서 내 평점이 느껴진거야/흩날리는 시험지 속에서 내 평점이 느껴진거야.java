
/*
현재 순서 그대로 K개의 그룹으로 나누고 
각각의 그룹에서 맞은 문제 개수의 합을 구하여 그중 최솟값을 시험 점수
최대 점수를 계산해라
푼문제는 모두 맞았으며 조교는 자신이 줄 수 있는 최대한의 점수를 준다. 
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시험지의 개수 (100000)
        int N = Integer.parseInt(st.nextToken());
        // 시험지를 나눌 그룹의 수 (100000)
        int K = Integer.parseInt(st.nextToken());

        // 시험지에 맞은 개수 담을 거임
        // 시험지를 현재 순서 그대로!!!
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 20 * N;
        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int idx = 0;
            // 현재까지 합친 점수
            int now = 0;
            int cnt = 0;

            while (idx < N) {
                if (now < mid) {
                    now += arr[idx];
                    idx++;
                } else {
                    cnt++;
                    now = 0;
                }
            }

            if (now >= mid) {
                cnt++;
            }
            // K 보다 크다는 것은 그 점수를 더 높게 받을 수 있는 확률 존재
            if (cnt >= K) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;

            }
        }
        System.out.println(answer);

    }
}