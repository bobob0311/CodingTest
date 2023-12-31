package greedy;
/*
정수 A를 B로 바꾸기 가능한 연산은 다음과 같은 두가지 
1. 2배하기
2. 1을 수의 가장 오른쪽에 추가하기
 */

/*
풀이는 거꾸로 계산하기 
마지막이 1이면 1을 제거 
마지막이 짝수면 2를 나눠서 값이 나오는지 확인해보면 될듯?
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준16953 {
    static int A, B;
    static int temp;
    static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while (true)

        {

            if (B == A) {
                System.out.println(count);
                break;
            }

            if (B < A) {
                System.out.println(-1);
                break;
            }
            if (B % 10 == 1) {
                B /= 10;
                count++;
            } else if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                System.out.println(-1);
                break;
            }

        }

    }

}
