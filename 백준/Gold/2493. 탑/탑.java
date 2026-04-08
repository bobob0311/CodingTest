import java.io.*;
import java.util.*;

/*
전에 중에 제일 가까운 나보다 크거나 같은 수의 인덱스를 찾아라




6 9
*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Stack<int[]> stk = new Stack<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = Integer.MAX_VALUE;

        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        stk.push(new int[] {0,Integer.MAX_VALUE});
        for(int i = 1; i<=N; i++){
            int nowNum = arr[i];
            while(true){
                int[] nowArr = stk.peek();
                int prevIdx = nowArr[0];
                int prevValue = nowArr[1];
                if(prevValue >= nowNum){
                    dp[i] = prevIdx;
                    stk.add(new int[] {i,nowNum});
                    break;
                }else{
                    stk.pop();
                }
            }
        }

        for(int i = 1; i<=N; i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb.toString());





    }

}