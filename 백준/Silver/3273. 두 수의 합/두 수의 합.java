import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        while(start < end){
            int now = arr[start] + arr[end];
            if(now == target){
                cnt++;
                start++;
                end--;
            }else if(now < target){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(cnt);
    }
}