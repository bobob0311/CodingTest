import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 자르는 횟수
        int N = Integer.parseInt(st.nextToken());
        // 자를 지점의 개수
        int M = Integer.parseInt(st.nextToken());
        // 롤케이크의 길이
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        int[] cut = new int[N];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            cut[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int start = 1;
            int end = L;
            int nowCut = cut[i];
            int answer = -1;

            while (start <= end) {
                int prev = 0;
                int cnt = 0;
                int mid = (start + end) / 2;

                int idx = 0;
                while (idx < M) {
                    if (arr[idx] - prev >= mid) {
                        cnt++;
                        prev = arr[idx];
                    }
                    idx++;
                }
                
                // 마지막 자른 부분이 만약 mid보다 작다면
                // 마지막에 그렇게 자르면 안된다. 
                
                if(L - prev < mid){
                    cnt--;
                }
                
                
                // 더 적게 잘리면 크기를 줄여야 된다.
                if (cnt < nowCut) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                    answer = mid;
                }

            }
            System.out.println(answer);
        }

    }
}