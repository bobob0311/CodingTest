import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

보석이 총 N개 Mi 무게 Vi가격
가방을 K개 가지고 있으며 담을 수 있는 최대 무게는 Ci이다.
가방안에는 최대 한 개의 보석만 넣을 수 있음

*/

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] cube = new int[N][2];
        int[] bag = new int[K];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> -Integer.compare(a[1],b[1]));

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            cube[i] = new int[] {m,v};
        }


        for(int i = 0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(cube, (a,b) -> Integer.compare(a[0], b[0]));

        long answer =0;
        int idx = 0;

        for(int i = 0; i< K; i++){
            int capacity = bag[i];

            while(idx<N && cube[idx][0] <=capacity){
                pq.offer(cube[idx]);
                idx++;
            }

            if(!pq.isEmpty()){
                answer += pq.poll()[1];
            }
        }

        System.out.println(answer);
    }
}