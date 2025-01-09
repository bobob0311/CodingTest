import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (pq.size() == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(-pq.poll());
                }
            } else {
                pq.add(-now);
            }
        }
    }
}