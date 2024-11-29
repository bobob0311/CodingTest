import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나무 수
        int N = Integer.parseInt(st.nextToken());
        
        // 나무 길이 
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long start = 0;
        long end = 2000000000;
        long answer = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            //  현재 트리 meter
            long now = 0;
            for(int tree : arr){
                long get = (long) tree - mid;
                if(get >0){
                    now+=(long)get;
                }
            }
            // 현재 tree 미터가 M보다 작은경우 더 작게 잘라야된다.
            if(now < M){
                end = mid - 1;
            }else{
                // 현재 tree 미터가 M보다 크거나 같은경우 
                start = mid + 1;
                answer = mid;
            }
        }
        
        System.out.println(answer);
    
    
    
    }
}