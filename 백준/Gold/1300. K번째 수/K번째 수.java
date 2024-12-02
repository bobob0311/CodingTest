import java.util.*;
import java.io.*;
/*
N => 100000 보다 작은 수 


1  2  3  4  5
2  4  6  8  10
3  6  9  12 15
4  8  12 16 20
5  10 15 20 25

*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열의 크기 N => N단까지
        int N = Integer.parseInt(br.readLine());
        // 몇 번째 원소인지
        long k = Integer.parseInt(br.readLine());
        long start = 0;
        long end = Math.max(1000000000,N*N);
        long answer = 0;
        while(start <= end){
            long mid = (start + end)/2;
            long cnt = 0;
            for(int i = 1; i<=N; i++){
                cnt += Math.min(mid/i, N);
            }
            // 밑에있는 수가 더 많다. 
            if(cnt >= k){
                end = mid -1;
                answer = mid;
            }else{
                start = mid +1;
            
            }
        }
        System.out.println(answer);
    }
    
}