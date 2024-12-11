import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 집 개수
        int N = Integer.parseInt(st.nextToken());
        // 공유기 개수
        int C = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        long start = 1;
        long end = 1000000000;
        long answer = -1;
        while(start <= end){
            int idx = 1;
            int cnt = 1;
            
            long prev = arr[0];
            long mid = (start+end)/2;
            
            while(idx < N){
                if(arr[idx] - prev >= mid){
                    cnt++;
                    prev = arr[idx];
                    continue;
                }
                idx++;
            }
            if(cnt < C){
                end = mid -1;
            }else{
                start = mid +1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}