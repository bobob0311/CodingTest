import java.util.*;
import java.io.*;

/*
한 번에 한개의 원판
쌓아 놓은 원판은 항상 위의 것이 아래 것보다 작아 

1개  1 => 3
2개  1 => 2 1 => 3 2 => 3
3개  1 => 3 1 => 2 3 => 2 1 => 3 2 => 1 2 => 3 1 => 3


1    1
   1 2

    
   1
   2  3



  
 */
public class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);
        System.out.println(cnt + "\n" + sb.toString());

    }

    static void hanoi(int num, int from, int mid, int to) {
        if (num == 1) {
            sb.append(from + " " + to + "\n");
            cnt++;
            return;
        }
        hanoi(num - 1, from, to, mid);
        cnt++;
        sb.append(from + " " + to + "\n");
        hanoi(num - 1, mid, from, to);
    }

}