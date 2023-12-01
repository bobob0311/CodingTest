package CodingTest.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

산성 용액     (1 ~ 1,000,000,000)  
알칼리성 용액 (-1,000,000,000 ~ -1)

같은 양의 두 용액을 혼합한 용액의 특성값은 --> 두용액 값을 더한 값


 < 두 용액을 혼합하여 특성값이 0 에 가장 가까운 용액을 만들려고한다 >
*/

/*

풀이)
1. 산성만 있는 경우
2. 알칼리만 있는 경우



3. 두개가 섞여있는 경우
   --> 양쪽의 끝에 포인터를 지정 두개를 더했을때 
   3-1 양수일 경우 --> 값을 줄여줘야 하기 때문에 오른쪽 포인터를 한칸 앞으로 당긴다.
   3-2 음수일 경우 --> 값을 늘려줘야 하기 때문에 왼쪽 포인터를 한칸 뒤로 민다.

   예외적으로 생각해볼 부분)
   음수 양수에서 출발해서 두개다 양수가 되는 경우에는? -> 어차피 오른쪽 포인터를 한칸 당기기때문에 ㄱㅊ
   음수도 같은 맥락


생각)
원래는 가운데에서 출발을 생각했었다.
왜안될까요????


정렬을 한후 가장 큰 음수와 가장 작은 양수를 각각 포인터로 지정
더했을때 음수가 될시에 양수포인터를 오른쪽으로 양수가 될시에 음수포인터를 왼쪽으로
---> 이렇게되면 풀이에 예외적으로 생각해볼 부분을 담을 수가 없다 
-100 -50 1 2 이런식으로 나오게되면 정답이 3이 나올수가 없게된다.
 */

/*
풀이 순서)
N (전체 용액의 수)가 10만이하이므로 int로 받아서 처리 
N 개의 용액의 특성값을 입력받아서 -10억~10억이므로 20억 안으로 들어오기때문에 int배열로 처리


1. 받은 용액의 특성값을 정렬

2. 전부다 양수인경우 0번인덱스와 1번 인덱스를 더한값이 최소 
3. 전부다 음수인경우 N-1번 인덱스와 N-2번 인덱스를 더한값이 최소 



4. 섞인경우 
    4-1 양수 포인터 음수포인터를 풀이와 같이 댕기기
    4-2 포인터를 옮길때 마다 최소값과 비교 최소값보다 작을시 교체 아닐시 유지  
        (최소값과 양수 포인터와 음수 포인터의 인덱스를 저장)
    4-3 양수포인터와 음수포인터가 만날시 종료
 */

public class 백준2467 {
    static int N; // 전체용액의 갯수

    static int[] arr; // 용액의 특성을 받아줄 배열

    static int idx1, idx2; // 각각 인덱스

    static int Mmin = 2000000000; // 최소값을 저장할 변수

    static int Ppointer, Mpointer;

    static int temp, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 받아오는 숫자 개수

        arr = new int[N];// N크기로 배열 초기화

        st = new StringTokenizer(br.readLine());

        // 배열에 값 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[0] > 0) {
            System.out.printf("%d %d", arr[0], arr[1]);
        } else if (arr[N - 1] < 0) {
            System.out.printf("%d %d", arr[N - 2], arr[N - 1]);
        } else {

            Mpointer = 0;
            Ppointer = N - 1;
            while (Mpointer != Ppointer) {
                temp = arr[Mpointer] + arr[Ppointer];
                res = Math.abs(temp);
                if (Mmin >= res) {
                    Mmin = res;
                    idx1 = Mpointer;
                    idx2 = Ppointer;
                }
                if (temp >= 0) {
                    Ppointer--;
                    // temp에 어느쪽이든 등호를 가져가야지만 된다 왜냐 0이 나올수도 있기때문에
                } else if (temp < 0) {
                    Mpointer++;
                }
            }
            System.out.printf("%d %d", arr[idx1], arr[idx2]);
        }

    }

}
