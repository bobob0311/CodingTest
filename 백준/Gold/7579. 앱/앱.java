import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N,M;
    static int[] memorys, costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        // 앱 개수
        N = Integer.parseInt(st.nextToken());
        // 필요한 메모리
        M= Integer.parseInt(st.nextToken());

        memorys = new int[N];
        costs = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++) memorys[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++) costs[i] = Integer.parseInt(st.nextToken());

        System.out.println(findSol());
    }

    static int findSol(){
        int[] dp = new int[10001];

        for(int i = 0; i< N; i++){
            int nowMemory = memorys[i];
            int nowCost = costs[i];

            for (int c = 10000; c >= nowCost; c--) {
                dp[c] = Math.max(dp[c], dp[c - nowCost] + nowMemory);
            }


            if(dp[nowCost] < nowMemory) dp[nowCost] = nowMemory;
        }
        int answer = 0;
        for(int i = 0; i<10001; i++){
            if(dp[i] >= M) return i;
        }

        return 0;
    }
}