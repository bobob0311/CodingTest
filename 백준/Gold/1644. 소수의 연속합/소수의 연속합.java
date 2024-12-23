import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;


        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int start = 0;
        int end = 0;
        int now = 0;
        int cnt = 0;

        while (end <= list.size()) {
            if (now >= n) {
                now -= list.get(start++);
            } else {
                if (end == list.size()) break;
                now += list.get(end++);
            }

            if (now == n) cnt++;
        }

        System.out.println(cnt);

    }
}