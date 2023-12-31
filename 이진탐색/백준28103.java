package 이진탐색;

//병신같은 문제 병신같은 문제 개 병신 같은 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
참가자수                   N   10^12
상품을 구매하기 위한 자금   X    10^18
구매할 수 있는 상품 개수    M    10^6
가격은                    ai


1등부터 나머지 참가자들 모두 상품+을 구매할 수 있는 한도내에서
가장 비싼 상품으로 결정!!


참가자수(N)    상품의 개수(M)     자금(X)
 */

/*
풀이) 

핵심적인 생각은 남은 상품중 제일 비싼 걸 A개를 샀을때 
총인원 N명중 제일비싼거 A개 제일 싼거 N-A개를 살수있는 제일 큰 A를 구하는것
제일 비싼거 즉 인덱스 0번째를 구한다음에는 
인덱스 1번째하고 같은 행동을 반복한다.


--> 이렇게만 하면될거같은데 
시간초과나오는게 모든 인덱스를 하나하나 돌아서 그러는줄 알고 그냥
0아닌 인덱스를 찾는 while문을 하나 더 추가한후에 그래도 시간초과가 나와서 
출력 방식을 바꿨더니 시간초과가 안나오더라고요...
 */

public class 백준28103 {
    static long N, X;
    static int M;
    static int[] arr;
    static long start, end, mid;
    static long res;
    static int startIdx, endIdx, midIdx;
    static long[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken()); // 참가자 수
        M = Integer.parseInt(st.nextToken()); // 상품의 개수
        X = Long.parseLong(st.nextToken()); // 자금

        result = new long[M];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        start = 1;
        end = N;

        // 맨처음한번 해보기
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[0] * mid + arr[M - 1] * (N - mid) > X) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result[0] = end;

        N -= end; // 총인원수 빠진만큼 경감
        X -= end * arr[0]; // 사용가능 금액
        res = X - (N - 1) * arr[M - 1]; // 한 사람이라도 다른거 탈게 만들수있는 최소금액

        // System.out.println(res);
        // System.out.println(X);

        startIdx = 1;
        endIdx = M - 1;

        while (true) {

            while (startIdx <= endIdx && endIdx >= 0) {
                midIdx = (startIdx + endIdx) / 2;
                if (arr[midIdx] > res) {
                    startIdx = midIdx + 1;
                } else {
                    endIdx = midIdx - 1;
                }
            }
            // System.out.println(startIdx);
            // System.out.println("현재인덱스:" + arr[startIdx]);
            // System.out.println("남은인원:" + N);
            if (startIdx > M - 1) {
                break;
            }

            if (startIdx == M - 1) {
                result[M - 1] = N;
                break;
            }

            start = 1;
            end = N;

            while (start <= end) {
                mid = (start + end) / 2;
                if (arr[startIdx] * mid + arr[M - 1] * (N - mid) > X) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            result[startIdx] = end;
            N -= end;
            X -= arr[startIdx] * end;
            res = X - (N - 1) * arr[M - 1];

            endIdx = M - 1;
            startIdx++;
        }
        // 그저 빠르게 출력할 수 있게
        // 사실 이거때문에 시간초과가 났었던거같긴합니다.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb.toString());
    }

}

// static void binary(long people, int idx, long money) {
// if (idx == M - 1) {
// System.out.print(people + " ");
// } else {
// start = 1;
// end = people;
// while (start <= end) {
// mid = (start + end) / 2;
// if (arr[idx] * mid + arr[M - 1] * (people - mid) > money) {
// end = mid - 1;
// } else {
// start = mid + 1;
// }
// }
// System.out.print(end + " ");
// binary(people - end, idx + 1, money - arr[idx] * end);
// }
// }
