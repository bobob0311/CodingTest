import java.util.*;
import java.io.*;
/*
M개의 사대

한 사대에서 거리가 L보다 작거나 같은 위치이 동물을 잡을 수 있다. 



*/
public class Main{
    static int M,N,L;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 사대의 수 (100000)
        M = Integer.parseInt(st.nextToken());
        // 동물의 수 (100000)
        N = Integer.parseInt(st.nextToken());
        // 사정거리 (십억)
        L = Integer.parseInt(st.nextToken());
        
        int[] pos = new int[M];
        int[][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<M; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pos);
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        
        int cnt = 0;
        int idx = 0;
        
        for(int i = 0; i<N; i++){
            int nowX = arr[i][0];
            int nowY = arr[i][1];
            if(idx + 1 < M){
                if(Math.abs(pos[idx+1] - nowX) < Math.abs(pos[idx] - nowX)){
                    idx++;
                } 
            }
            
            int x = pos[idx];
                
            if(Math.abs(x - nowX) + nowY <= L){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}