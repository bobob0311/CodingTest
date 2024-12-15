
/*
돌섬에서 탈출구까지 존재하는 작은돌섬들로 점프
n개의 작은 돌섬 => m개 제거

점프한 거리의 최솟값을 최대한 크게 하려고한다. 
n-m 개 다 밟아야한다. 


*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long d = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        arr[n] = d;
        Arrays.sort(arr);

        long start = 0;
        long end = d;

        long answer = 0;

        while (start <= end) {
            int cnt = 0;
            // 내가 뛰는 거리
            long mid = (start + end) / 2;
            long prev = 0;

            for (int i = 0; i < n + 1; i++) {
                if (arr[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = arr[i];
                }
            }

            if (cnt <= m) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;

            }
        }
        System.out.println(answer);
    }
}