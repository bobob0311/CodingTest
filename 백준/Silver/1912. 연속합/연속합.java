import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[M];
        
        int answer = -(Integer.MAX_VALUE-1);
        dp[0] = arr[0];
        answer = Math.max(dp[0],answer);
        for(int i = 1; i<M; i++){
            if(dp[i-1] + arr[i] > arr[i]){
                dp[i] = dp[i-1] + arr[i];
            }else{
                dp[i] = arr[i];
            }
            answer = Math.max(dp[i],answer);
        }
        
        System.out.println(answer);
        
    }
}