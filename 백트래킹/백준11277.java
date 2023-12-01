package CodingTest.백트래킹;

/*
2-CNF 식은 절 즉 괄호로 묶인식은 OR
그 절끼리는 AND로 되어있다.
변수의 개수 N개
절의 개수 M
그리고 식 f가 주어졌을때 
f를 true로 만들 수 있는지 없는지 구하는 프로그램작성

*/

/*
풀이 )
N개 의 변수는 true, false로 두가지를 갖을 수 있다 
모든 경우의 수를 돌면서 모든 절이 true가 되는 찾아본다 

=> 경우의 수를 돌면서 한 절이라도 true가 아니라 false가 나오면 
그 경우의 수는 true가 아닌 false이다 
이 말을 코드로 구현
 */

/*
int    N -> 변수의 개수 (1~20)
int    M -> 절의 개수 (1~100)

int[]   arr -> 각 인덱스에 따라서 true, false 경우의 수 담을 배열
int[][] arr2 -> 절안에 관계를 담아둘 배열


 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11277 {
    static int N, M; // N은 변수의 개수 , M은 절의 개수
    static boolean[] arr; // N개의 불리안 변수를 담을것 근데 숫자로 담을까
    static int[][] arr2; // 절을 담아두는 변수

    static int temp1, temp2; // 절안에서의 앞 변수 뒤 변수를 저장
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 변수의 개수
        M = Integer.parseInt(st.nextToken()); // 절의 개수

        arr = new boolean[N + 1]; // 1~N인덱스로 저장 -> arr2에 인덱스에 담겨있는 그대로 구현하기 위해
        arr2 = new int[M][2]; // M개의 절 앞변수 뒤변수 이므로

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Back(1);
        // 저렇게 꺼내고 그냥 count를 뽑아냈는데 오류가 나옴
        // count가 1이상으로 뽑히는 경우가 존재하는듯 고쳐야할 필요성이있을수도..

        if (count > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);

        }
    }

    static void Back(int index) {
        if (index == N + 1) { // index가 N+1이다? 즉 N번의 index까지 처리를 밑에서 했다.
            for (int k = 0; k < M; k++) {
                temp1 = arr2[k][0]; // 앞변수
                temp2 = arr2[k][1]; // 뒷변수
                boolean value1 = (temp1 > 0) ? arr[temp1] : !arr[-temp1]; // 음수와 양수인경우 각 변수의 true / false를 결정
                boolean value2 = (temp2 > 0) ? arr[temp2] : !arr[-temp2]; // 음수와 양수인경우 각 변수의 true / false를 결정
                // 절중에 하나라도 false가 나오게 되면 이 경우의수는 나가리 이므로 바로 return
                if (!(value1 || value2)) {
                    return;
                }
            }
            // for문 다돌렸는데 즉 모든 절을 다봤는데 모든절이 true이므로
            // 식 f를 true로 만들 수 있는 것을 찾았으므로 count를 하나 올려주고 return
            count++;
            return;
        }

        // 어느 시점이든 count가 1보다 크다는것은 하나라도 true를 찾았다는 거이므로 그냥 더 돌리지 말고 return
        // 이거 좀 뭔가 어거지 느낌?
        if (count != 0) {
            return;
        }

        // index N까지 true false 경우의수 돌기
        arr[index] = true;
        Back(index + 1);
        arr[index] = false;
        Back(index + 1);
    }
}
