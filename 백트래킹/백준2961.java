package CodingTest.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
재료 N개 
신맛 S  
쓴맛 B
음식의 신맛은 사용한 재료의 신맛의 곱
음식의 쓴맛은 사용한 재료의 쓴맛의 합

신맛과 쓴맛이 주어졌을때 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램

*/

/*
N (1 ~10)
쓴맛과 신맛은 모두 10억보다 작은양의 정수
 */

public class 백준2961 {

    static int N, S, B;
    static int[] arr1, arr2; // arr1에는 신맛을 담고 arr2에는 쓴맛을 담아볼까?
    static int Mintemp = 1000000000;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 변수의 개수

        arr1 = new int[N]; // 1~N인덱스로 저장 -> arr2에 인덱스에 담겨있는 그대로 구현하기 위해
        arr2 = new int[N]; // M개의 절 앞변수 뒤변수 이므로
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Back(0, 1, 0);

        System.out.println(Mintemp);
    }

    static void Back(int idx, int num1, int num2) {
        if (idx >= 1) {
            if (Math.abs(num1 - num2) < Mintemp) {
                Mintemp = Math.abs(num1 - num2);
            }
        }

        if (idx == N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                Back(idx + 1, num1 * arr1[i], num2 + arr2[i]);
                visited[i] = false;
            }

        }

    }
}
