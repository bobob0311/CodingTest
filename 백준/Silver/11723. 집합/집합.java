import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N, mask;
    static StringBuilder sb = new StringBuilder();
    static int[] bits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        bits = new int[1<<21];

        for(int i = 0; i<N; i++){
            sol(br.readLine());
        }

        System.out.println(sb.toString());
    }

    static void sol(String str){
        st = new StringTokenizer(str);
        String chk = st.nextToken();
        int num = 0;


        switch (chk){
            case "add":
                num = Integer.parseInt(st.nextToken());
                mask |= (1<<num);
                break;
            case "remove":
                num = Integer.parseInt(st.nextToken());
                mask &= ~(1<<num);
                break;
            case "check":
                num = Integer.parseInt(st.nextToken());
                sb.append((mask & (1<<num)) != 0 ? "1\n": "0\n");
                break;
            case "toggle":
                num = Integer.parseInt(st.nextToken());
                mask ^=(1<<num);
                break;
            case "all":
                mask = (1<<21) -1;
                break;
            case "empty":
                mask = 0;
                break;
        }
    }
}