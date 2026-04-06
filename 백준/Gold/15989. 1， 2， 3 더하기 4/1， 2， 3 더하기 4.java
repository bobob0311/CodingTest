import java.io.*;
import java.util.*;

/*
정수 n이 주어졌을 때 n을 1,2,3,의 합으로 나타내는 방법의 수를 구하여라
합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] dp;

    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[100001][4];
        sol();

        for(int i = 0; i< T; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][1]+dp[num][2]+dp[num][3] );
        }


    }

    static void sol(){
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;



        for(int i =4 ; i<= 10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
    }





}