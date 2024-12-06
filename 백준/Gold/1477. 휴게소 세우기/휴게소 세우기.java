import java.util.*;
import java.io.*;

/*
N개의 휴게소 => 고속도로의 시작으로부터 얼만큼 떨어져 있는지 
M개 더 세울것이다. 

있는 곳 끝에 안되고 정수 위치에만 가능

휴게소가 없는 구간의 길이의 최댓값을 최소로 하고싶다. (M개 다 지어야함)

얼마나 균등하게 나누는가가 포인트 인데...


*/
public class Main{
    static int N,M,L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int start = 1;
        int end = L;
        
        int mid = 0;
        int answer =0;
        
        while(start <= end){
            
            int cnt = 0;
            mid = (start + end)/2;
            
      
            for (int i = 1; i < arr.length; i++) {
                cnt += (arr[i] - arr[i - 1] - 1) / mid;
            }
            
           if(cnt > M){
               start = mid +1;
           }else{
               end = mid -1;
               answer = mid;
           }
            
        }
        
        System.out.println(answer);
        
        
    }
}
