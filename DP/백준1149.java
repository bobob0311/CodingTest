package DP;

import java.util.*;
import java.io.*;

/*
1~N번집이 순서대로 있다
빨강, 초록, 파랑 중 하나의 색으로 칠한다 // 비용을 최소로하게 만들어봐라

- 1번 집의 색은 2번 집의 색과 달라야함
- N번 집의 색은 N-1번 집의 색과 같지 않아야 한다
- i(2~N-1) 번 집의 색은 i-1,i+1집의 색과 같지 않아야한다.

- 

 */

public class 백준1149 {
    static int N;
    static int[][] arr;
    static int red, green, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            red = Integer.parseInt(st.nextToken());
            green = Integer.parseInt(st.nextToken());
            blue = Integer.parseInt(st.nextToken());

            arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + red;
            arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + green;
            arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + blue;
        }

        int temp = 1000001;
        for (int i = 0; i < 3; i++) {
            if (temp > arr[N][i]) {
                temp = arr[N][i];
            }
        }
        System.out.println(temp);

    }

}
