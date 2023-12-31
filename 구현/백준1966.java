package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1966 {
    static int N; // 테스트 케이스가 몇개인가
    static int count, target; // 궁금한 현재 문서의 위치
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        while (N != 0) {
            N--;
            st = new StringTokenizer(br.readLine());

            count = Integer.parseInt(st.nextToken()); // 문서의 개수
            target = Integer.parseInt(st.nextToken()); // 문서의 현재 위치

            st = new StringTokenizer(br.readLine());
            arr = new int[10000];
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = count;

            int res = 0;

            while (res != -1) {
                int k = start;

                for (int i = start; i < end; i++) {

                    // k가 내가 확인하고있는거
                    if (arr[k] < arr[i]) {

                        arr[end] = arr[k];

                        start++;
                        end++;

                        if (k == target) {
                            target += end - start;
                        }
                        break;

                    } else if (i == end - 1) {
                        res++; // 이게
                        start++;

                        if (k == target) {
                            System.out.println(res);
                            res = -1;
                            break;
                        }

                    }

                }
            }
        }
    }

}
