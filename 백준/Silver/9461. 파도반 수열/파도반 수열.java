import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        arr[9] = 7;
        arr[10] = 9;
        for (int i = 11; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            System.out.println(arr[now]);
        }
    }
}