import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i = 1; i< N+1; i++){
            arr[i] = i;
        }
        
        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp; 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < N+1 ; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }
}