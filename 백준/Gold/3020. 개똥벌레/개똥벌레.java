import java.util.*;
import java.io.*;

public class Main {
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[2*H +1];
        
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(i % 2 == 0){
                arr[1] += 1;
                arr[num*2 +1] += -1;
            }else{
                arr[2*H - num*2] += 1;
            }
        }
        
        for(int i = 1; i<= 2*H ; i++){
            arr[i] += arr[i-1]; 
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<= 2*H; i+=2){
            min = Math.min(arr[i], min);
        }
        int cnt = 0;
        for(int i = 1; i<= 2*H; i+=2){
            if(arr[i] == min){
                cnt++;
            }
        }
        
        System.out.println(min+" "+cnt);
    }
}