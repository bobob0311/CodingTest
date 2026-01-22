import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N,T,M,start,end;
    static int[] memo;
    static int INF = 1000000000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        // 이전 상태
        memo = new int[N];
        // 현재 상태
        int[] now = new int[N];

        Arrays.fill(memo,INF);
        Arrays.fill(now,INF);

        memo[start] = 0;
        now[start] = 0;

        for(int t = 0; t<T; t++){

            for(int j = 0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());


                if(memo[v1] != INF && now[v2] > memo[v1] + w) now[v2] = memo[v1] + w;
                if(memo[v2] != INF && now[v1] > memo[v2] + w) now[v1] = memo[v2] + w;

            }

            for(int i = 0; i< N; i++){
                memo[i] = now[i];
            }

        }



        if(memo[end] == INF) System.out.println(-1);
        else System.out.println(memo[end]);

    }

}