package CodingTest.백트래킹;

/*
한 절이라도 false false가 나올수 밖에 없는 상황이면 0 아니면 1

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11277 {
    static int N, M; // N은 변수의 개수 , M은 절의 개수
    static boolean[] arr; // N개의 불리안 변수를 담을것 근데 숫자로 담을까
    static int[][] arr2; // 절을 담아두는 변수
    static int temp1, temp2; // 앞의 변수 뒤에 변수 저장
    static int temp1T, temp2T;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 변수의 개수
        M = Integer.parseInt(st.nextToken()); // 절의 개수

        arr = new boolean[N + 1]; // 1~N인덱스로 저장
        arr2 = new int[M][2];

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
        if (index == N + 1) {
            for (int k = 0; k < M; k++) {
                temp1 = arr2[k][0];
                temp2 = arr2[k][1];
                boolean value1 = (temp1 > 0) ? arr[temp1] : !arr[-temp1];
                boolean value2 = (temp2 > 0) ? arr[temp2] : !arr[-temp2];
                if (!(value1 || value2)) {
                    return;
                }
            }
            count++;
            return;
        }

        if (count != 0) {
            return;
        }

        arr[index] = true;
        Back(index + 1);
        arr[index] = false;
        Back(index + 1);
    }
}
