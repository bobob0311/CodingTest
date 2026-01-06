import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> -Long.compare(a,b));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                pq.offer(Long.parseLong(st.nextToken()));
            }
        }
        long answer = 0;
        for(int i = 0; i< N; i++){
            answer = pq.poll();
        }

        System.out.println(answer);


    }
}