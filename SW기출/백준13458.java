package SW기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N개의 시험장
i번 째 시험장의 응시자 수는 Ai명
감독관은 총감독관/부감독관

총감독관은 B명을 감시가능
부감독관은 C명을 감시가능

총감독관은 오직 1명 부감독관은 여러명 가능
응시생들을 모두 감시해야할 때 필요한 감독관 수의 최솟값 구하기
*/

/*
시험장의 개수 N
각 시험자의 응시자 수
B C
 */
public class 백준13458 {
    static int N;
    static int[] arr;
    static int b, c;
    static double count = 0; // count를 doulbe로 해야한다. 이러한 자료형을 먼저 확정시키자

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int temp = arr[i];

            temp -= b; // 총시험관 한명
            count++;

            if (temp > 0) { // 만약 총시험관 한명을 했는데도 사람이 남을 경우
                int plus = temp / c;
                count += plus;
                int test = temp % c;
                if (test != 0) {
                    count++;
                }
            }

            // while (temp > 0) {
            // temp -= c;
            // count++;
            // }
            // 시간초과 나옴
        }
        System.out.printf("%.0f", count);
    }
}
