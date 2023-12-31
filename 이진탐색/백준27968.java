package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
사탕이 무한한 사탕봉지
N명의 아이들에게 순서대로 사탕 배분
한명의 아이가 새로 올 때마다 사사는 사탕을 최대 M번 꺼내고 A1,A2...AM 개씩 꺼낸다
사탕을 꺼낼땐 반드시 하나 이상을 꺼낸다
i번째로오는 아이는 Bi개를 받고싶어한다
i번째에게 줄때 꺼낸 사탕 개수의 합이 Bi이상이면 사사가 꺼낸 모든 사탕을 받고 떠나기
M번을꺼냈는데도 아이가 원하는 수가 안되면 쫒아냄

 */

/*
N M
N은 아이의수, M은 사탕을 꺼내주는 최대 횟수 (1부터 30만이하)
A나열 -> 10억이하
N개의 줄로 Bi가 나열 BI는 10^12
 */

public class 백준27968 {
    static int N, M;
    static double[] arr1, arr2;
    static double[] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new double[M];
        arr1 = new double[M];

        arr2 = new double[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr1[i] = Double.parseDouble(st.nextToken());
        }

        for (int j = 0; j < N; j++) {
            arr2[j] = Double.parseDouble(br.readLine());
        }

        res[0] = arr1[0];

        if (M > 1) {
            for (int i = 1; i < M; i++) {
                res[i] = res[i - 1] + arr1[i];
            }
        }

        for (int i = 0; i < N; i++) {
            binary(arr2[i]);
        }
    }

    static void binary(double target) {
        int start = 0;
        int end = M - 1;
        int mid;
        if (M == 1) {
            if (res[0] < target) {
                System.out.println("Go away!");
                return;
            } else if (res[0] >= target) {
                System.out.println("1");
                return;
            }
        }

        if (res[0] >= target) {
            System.out.println("1");
            return;
        }

        while (true) {
            mid = (start + end) / 2;

            // mid 가 0 이 될 수 있는 경우는 start = 0 end가 1인경우밖에없다
            // 이말은 전에 mid가 1번 인덱스였다는 것이고 1번 인덱스는 target보다 크니 1이 될수도 0이 될수도있네?

            if (mid == 0) {
                if (res[0] < target && res[1] >= target)
                // 부등호 거꾸로쓰고 하루죙일을 못찾았네요?
                // 네이밍을 의미있게 하자
                {
                    System.out.println("2");
                    return;
                } else {
                    System.out.println("1");
                    return;
                }
            }

            if (res[mid] >= target && res[mid - 1] < target) {
                System.out.println(mid + 1);
                return;
            }

            if (res[mid] < target) {
                start = mid + 1;
            }
            if (res[mid] > target) {
                end = mid;
            }

            if (start > end) {
                System.out.println("Go away!");
                return;
            }

        }
    }
}
