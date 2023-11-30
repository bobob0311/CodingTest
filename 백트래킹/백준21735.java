package CodingTest.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
앞마당의 길이 N
위치 1 ~ N까지 눈
i위치에 Ai만큼의 눈
M초동안 눈덩이를 굴려 눈사람 만들기 
시작크기는 1 시작 위치는 0

1. 위치 +1 
    눈덩이의 크기는 A(i+1)만큼 느어간다
2. 위치 +2  
    원래 크기의 반으로 줄어들고
    눈덩이의 크기는 A(i+2 만큼 늘어난다) =--> 소수점 절사 

끝나는 조건
대회시간 1~10 -> 10초후에 끝남
앞마당의 길이 1~100 -> 앞마당에 끝에 도달한 경우


 */

/*
길이를 저장하는 변수   --> int N (1 ~100)
대회의 시간           --> int M (1~10)
길이를 담을 배열       --> int[] arr;
 */

public class 백준21735 {
    static int N, M;
    static int[] arr;
    static int MMax = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 앞마당의 길이
        M = Integer.parseInt(st.nextToken()); // 대회의 시간

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count(0, 0, 1);

        System.out.println(MMax);
    }

    // 시간이 끝나거나 길이를 넘어갔을때
    static void count(int idx, int time, int res) {
        if (time <= M) {
            MMax = Math.max(MMax, res);
        }
        if (time > M) {
            return;
        }
        if (idx <= N - 1) {
            count(idx + 1, time + 1, res + arr[idx + 1]);
        }
        if (idx <= N - 2) {
            count(idx + 2, time + 1, (res / 2) + arr[idx + 2]);
        }
        return;
    }
}
