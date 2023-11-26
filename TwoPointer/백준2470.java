/*
산성 1 ~ 1e10
알칼리 -1 ~ -1e-10
같은 양의 두 용액을 혼합하여 0에 가장 가까운 용액을 만들라고한다
0에 가장 가까운 혾바용액을 만드는 프로그램을 작성하시오
 */

/*
전체 용액의 수: N (2<= N <= 100000)
 */

/*
1. 모두 산성인경우 -> 가장 작은 두개 더하면 0에 제일 가까움
2. 모두 알칼리인경우 -> 동일
3. 섞인경우 절대값이 비슷할수록 


--> 배열을 우선 산성만 있는지 알칼리만 있는지 판단
산성 혹은 알칼리만 있으면 배열 정렬해서 바로 
--> 섞여있는 경우는 배열을 음수랑 양수로 나눠서 정렬
그후 각자 배열의 포인터를 변경해가면서 고고링
뭔말알?
*/

/*
고려못한것
1. 양수랑 음수가 섞여있어도  양수+양수가 양수 +음수보다 절대값이 작을 수있다.
2. 비슷한 접근이라도 계산의 횟수를 더 줄여줄수있는 방법은 있다.
 */

package CodingTest.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준2470 {
    static int N; // 개수
    static int[] arr; // 받아올 배열
    static int Ppointer, Mpointer, temp, tempT;
    static int Mini = 2000000001;
    static int[] res = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 받아오는 숫자 개수

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[N - 1] <= 0) {
            System.out.print(arr[N - 2] + " " + arr[N - 1]);
        } else if (arr[0] >= 0) {
            System.out.print(arr[0] + " " + arr[1]);
        } else {

            Ppointer = N - 1;
            Mpointer = 0;
            while (arr[Mpointer] != arr[Ppointer]) {
                temp = arr[Ppointer] + arr[Mpointer];
                tempT = Math.abs(temp);
                if (tempT < Mini) {
                    Mini = tempT;
                    res[0] = Mpointer;
                    res[1] = Ppointer;
                }
                if (temp < 0) {
                    Mpointer++;
                } else if (temp == 0) {
                    break;
                } else if (temp > 0) {
                    Ppointer--;
                }
            }
            System.out.print(arr[res[0]] + " " + arr[res[1]]);
        }

    }

}
