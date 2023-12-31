package 구현;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준10828 {
    static int[] arr = new int[10001];
    static int N;
    static String temp;
    static int idx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            {
                temp = br.readLine();
                stack(temp);
            }

        }

    }

    static void stack(String x) {
        if (x.equals("pop")) {
            if (idx == 0) {
                System.out.println(-1);
            } else {
                System.out.println(arr[idx - 1]);
                idx--;
            }

        } else if (x.equals("size")) {
            System.out.println(idx);
        } else if (x.equals("empty")) {
            if (idx == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (x.equals("top")) {
            if (idx == 0) {
                System.out.println(-1);
            } else {
                System.out.println(arr[idx - 1]);
            }
        } else {
            String now = x.substring(5);
            int res = Integer.parseInt(now);
            arr[idx] = res;
            idx++;

        }

    }
}
