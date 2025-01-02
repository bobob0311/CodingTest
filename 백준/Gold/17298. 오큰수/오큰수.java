import java.util.*;
import java.io.*;

/*
오른쪽에 있으면서 첫번째로 만나는 큰 수 
7
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stk = new Stack<>();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int now = arr[i];
            while (!stk.empty()) {
                if (now > arr[stk.peek()]) {
                    int index = stk.pop();
                    answer[index] = now;
                } else {
                    break;
                }
            }
            stk.push(i);
        }

        while (!stk.empty()) {
            int index = stk.pop();
            answer[index] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());

    }
}