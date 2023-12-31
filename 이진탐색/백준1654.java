package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N개의 랜선 만들기 
K개의 랜선이 있는데 길이가 제각각
랜선을 모두 N개의 같은 길이의 랜선으로 
K개를 N개로 만들수없는 경우는없다 
센티미터 단위로 정수로 자른다 
N개보다 많이 만드는 것도 N개를 만드는것에 포함
만들수있는 최대 랜선의 길이를 구해보아라
 */

/*
가지고있는 랜선의 개수 K (1   10000) 
필요한 랜선의 개수 N (1     1000000)
K줄에 걸쳐 이미 가지고있는 각 랜선의 길이 2^31 -1

 */

/*
각 랜선의 길이를 다 더한다음에 개수로 나눠서 최대 길이를 구한다?
의미가없을거같은데요
최소 길이는 ? 0부터 가요?
 */

// 숫자 범위 생각안하고 int로 박아버리기 
// 그냥 무지성으로 뇌 없이 하나하나 코딩시작해서 복잡하게 만들어버리기
// 예외가 없도록 애초에 코드를 생각해서 짜길

public class 백준1654 {
    static int K, N;
    static double[] arr, temp;
    static double sum;
    static int sumC;
    static long MMax;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        temp = new double[K];
        arr = new double[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        MMax = (long) sum / N;
        // 최대 길이
        binary(MMax);

    }

    static void binary(long Max) {
        long start = 1;
        long end = Max;
        long mid;
        while (start <= end) {
            mid = (start + end) / 2;
            sumC = 0;
            for (int i = 0; i < K; i++) {
                sumC += arr[i] / mid;
            }

            if (sumC >= N) {
                start = mid + 1;
            }
            if (sumC < N) {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }

}
